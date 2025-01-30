package com.nexaiprotocol.common.config.mainnet;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Configuration class for storing blockchain-related information such as URL, address, private key, and contract address.
 * This class is typically used to map configuration properties from a YAML or properties file.
 *
 * <p>Example YAML configuration:
 * <pre>
 * mainnet:
 *   solana:
 *     url: "https://api.mainnet-beta.solana.com"
 *     address: "your-wallet-address"
 *     publicKey: "your-public-key"
 *     privateKey: "your-private-key"
 *     contract: "your-contract-address"
 * </pre>
 *
 * @since 1.0
 */

@Data
@Component
public class MainnetConfigInfo {

    /**
     * The URL endpoint for interacting with the blockchain network.
     * This is typically the RPC endpoint used to send requests to the blockchain node.
     * Example: "https://api.mainnet-beta.solana.com"
     */
    private String url;

    /**
     * The wallet address associated with the blockchain network.
     * This is typically used to identify the sender or receiver of transactions.
     * Example: "0xYourWalletAddress"
     */
    private String address;

    /**
     * The private key associated with the wallet address.
     * This is used to sign transactions and authenticate interactions with the blockchain network.
     * Note: Ensure this value is kept secure and never exposed in production environments.
     * Example: "your-private-key"
     */
    private String privateKey;


    /**
     * The public key associated with the wallet address.
     * This is used to verify transactions and authenticate interactions with the blockchain network.
     * Unlike the private key, the public key can be safely shared and is often used to identify the wallet address.
     * Example: "your-public-key"
     */
    private String publicKey;

    /**
     * The contract address associated with the blockchain network.
     * This is typically used for interacting with smart contracts deployed on the blockchain.
     * Example: "0xYourContractAddress"
     */
    private String contract;
}