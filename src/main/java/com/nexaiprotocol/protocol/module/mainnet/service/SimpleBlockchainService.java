package com.nexaiprotocol.protocol.module.mainnet.service;


import com.nexaiprotocol.common.config.mainnet.MainnetConfiguration;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainFactory;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainMainnet;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainService;
import com.nexaiprotocol.protocol.module.mainnet.client.BlockchainHttpClient;
import com.nexaiprotocol.protocol.module.mainnet.factory.DefaultBlockchainFactory;
import org.springframework.stereotype.Service;

/**
 * Abstract service implementation for interacting with multiple blockchains.
 * This service provides a unified interface to interact with different blockchain networks
 * (e.g., Base, Ethereum, Solana, Polygon) by leveraging a {@link BlockchainFactory} to create
 * blockchain-specific instances.
 *
 * <p>Key responsibilities:
 * <ul>
 *   <li>Initializes a {@link BlockchainFactory} to create blockchain instances.</li>
 *   <li>Provides a method to retrieve a blockchain instance based on the specified chain.</li>
 * </ul>
 *
 * @since 1.0
 */
@Service
public class SimpleBlockchainService implements BlockchainService {

    private final BlockchainFactory blockchainFactory;

    private final MainnetConfiguration mainnetConfiguration;

    /**
     * Constructs a new instance of {@link SimpleBlockchainService}.
     *
     * @param httpClient           The {@link BlockchainHttpClient} used for making HTTP requests to blockchain networks.
     * @param mainnetConfiguration The {@link MainnetConfiguration} containing settings for supported blockchains.
     */
    public SimpleBlockchainService(BlockchainHttpClient httpClient, MainnetConfiguration mainnetConfiguration) {
        this.blockchainFactory = new DefaultBlockchainFactory(httpClient, mainnetConfiguration);
        this.mainnetConfiguration = mainnetConfiguration;
    }

    /**
     * Retrieves a blockchain instance for the specified chain.
     * This method uses the {@link BlockchainFactory} to create and return a blockchain-specific implementation.
     *
     * @param chain The name of the blockchain network (e.g., "solana", "ethereum", "base", "polygon").
     * @return An instance of {@link BlockchainMainnet} for the specified chain.
     * @throws IllegalArgumentException If the specified chain is not supported.
     */
    @Override
    public BlockchainMainnet getBlockchainInstance(String chain) {
        return blockchainFactory.createBlockchain(chain);
    }
}
