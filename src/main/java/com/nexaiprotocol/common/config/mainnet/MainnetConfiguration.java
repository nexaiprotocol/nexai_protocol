package com.nexaiprotocol.common.config.mainnet;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Parent configuration class for all blockchain networks.
 * This class maps configuration properties under the `mainnet` prefix in the YAML or properties file.
 * It holds configurations for multiple blockchain networks, such as Base, Ethereum, Solana, and Polygon.
 *
 * <p>Example YAML configuration:
 * <pre>
 * mainnet:
 *   base:
 *     url: "https://mainnet.base.org"
 *     address: "your-wallet-address"
 *     privateKey: "your-private-key"
 *     contract: "your-contract-address"
 *   ethereum:
 *     url: "https://mainnet.infura.io/v3/your-project-id"
 *     address: "your-wallet-address"
 *     privateKey: "your-private-key"
 *     contract: "your-contract-address"
 *   solana:
 *     url: "https://api.mainnet-beta.solana.com"
 *     address: "your-wallet-address"
 *     privateKey: "your-private-key"
 *     contract: "your-contract-address"
 *   polygon:
 *     url: "https://polygon-mainnet.infura.io/v3/your-project-id"
 *     address: "your-wallet-address"
 *     privateKey: "your-private-key"
 *     contract: "your-contract-address"
 * </pre>
 *
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "mainnet")
public class MainnetConfiguration {

    /**
     * Configuration for the Base blockchain network.
     * Contains properties such as URL, address, private key, and contract address.
     */
    private MainnetConfigInfo base;

    /**
     * Configuration for the Ethereum blockchain network.
     * Contains properties such as URL, address, private key, and contract address.
     */
    private MainnetConfigInfo ethereum;

    /**
     * Configuration for the Solana blockchain network.
     * Contains properties such as URL, address, private key, and contract address.
     */
    private MainnetConfigInfo solana;

    /**
     * Configuration for the Polygon blockchain network.
     * Contains properties such as URL, address, private key, and contract address.
     */
    private MainnetConfigInfo polygon;
}
