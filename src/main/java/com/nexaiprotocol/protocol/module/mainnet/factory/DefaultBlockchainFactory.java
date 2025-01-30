package com.nexaiprotocol.protocol.module.mainnet.factory;


import com.nexaiprotocol.common.config.mainnet.MainnetConfiguration;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainMainnet;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainFactory;
import com.nexaiprotocol.protocol.module.mainnet.client.BlockchainHttpClient;
import com.nexaiprotocol.protocol.module.mainnet.net.impl.SimpleEthereum;
import com.nexaiprotocol.protocol.module.mainnet.net.impl.SimplePolygon;
import com.nexaiprotocol.protocol.module.mainnet.net.impl.SimpleBaseChain;
import com.nexaiprotocol.protocol.module.mainnet.net.impl.SimpleSolana;

/**
 * Factory class for creating Blockchain instances.
 *
 * @since 1.0
 */

public class DefaultBlockchainFactory implements BlockchainFactory {

    private final BlockchainHttpClient httpClient;

    private final MainnetConfiguration config;

    public DefaultBlockchainFactory(BlockchainHttpClient httpClient, MainnetConfiguration config) {
        this.httpClient = httpClient;
        this.config = config;
    }

    /**
     * Creates a Blockchain instance for the specified chain.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base","polygon").
     * @return A Blockchain instance.
     * @throws IllegalArgumentException If the chain is not supported.
     */
    @Override
    public BlockchainMainnet createBlockchain(String chain) {

        if (httpClient == null) {
            throw new IllegalStateException("BlockchainHttpClient is not initialized");
        }
        return switch (chain.toLowerCase()) {
            case "solana" -> new SimpleSolana(httpClient, config.getSolana());
            case "ethereum" -> new SimpleEthereum(httpClient, config.getEthereum());
            case "polygon" -> new SimplePolygon(httpClient, config.getPolygon());
            case "base" -> new SimpleBaseChain(httpClient, config.getBase());
            default -> throw new IllegalArgumentException("Unsupported blockchain: " + chain);
        };
    }
}
