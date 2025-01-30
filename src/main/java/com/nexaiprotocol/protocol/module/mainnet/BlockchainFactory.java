package com.nexaiprotocol.protocol.module.mainnet;


/**
 * Interface for creating Blockchain instances.
 *
 * @since 1.0
 */


public interface BlockchainFactory {
    /**
     * Creates a Blockchain instance for the specified chain.
     *
     * @param chain The blockchain name (e.g., "solana", "ethereum", "base").
     * @return A Blockchain instance.
     * @throws IllegalArgumentException If the chain is not supported.
     */
    BlockchainMainnet createBlockchain(String chain);
}
