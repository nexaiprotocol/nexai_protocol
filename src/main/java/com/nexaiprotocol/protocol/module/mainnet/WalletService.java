package com.nexaiprotocol.protocol.module.mainnet;


import com.nexaiprotocol.model.entity.WalletEntity;

import java.util.List;

/**
 * Wallet Service Interface
 * This interface defines the method for creating a wallet.
 * Concrete implementations of this interface should provide wallet creation functionality.
 *
 * @since 1.0
 */
public interface WalletService {

    /**
     * Creates a new wallet.
     *
     * <p>
     * This method is used to generate a new wallet, which includes mnemonic phrases,
     * public key, private key, and address. Concrete implementations should provide
     * support for creating wallets for different blockchains (e.g., Solana, Ethereum).
     * </p>
     *
     * @param mnemonicCode mnemonic code 12 words
     * @return WalletEntity an entity object containing wallet information
     * @throws Exception if an error occurs during wallet creation
     */
    WalletEntity createWallet(List<String> mnemonicCode) throws Exception;

}
