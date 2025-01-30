package com.nexaiprotocol.common.config;

import com.nexaiprotocol.common.config.mainnet.MainnetConfiguration;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainFactory;
import com.nexaiprotocol.protocol.module.mainnet.factory.DefaultBlockchainFactory;
import com.nexaiprotocol.protocol.module.mainnet.client.BlockchainHttpClient;
import com.nexaiprotocol.protocol.module.mainnet.client.DefaultBlockchainHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining and initializing beans required by the application.
 * This class is responsible for creating and configuring instances of key components,
 * such as the HTTP client for blockchain communication, the mainnet configuration,
 * and the blockchain factory.
 *
 * <p>Beans defined in this class:
 * <ul>
 *   <li>{@link BlockchainHttpClient}: A client for making HTTP requests to blockchain networks.</li>
 *   <li>{@link MainnetConfiguration}: A configuration class holding settings for multiple blockchain networks.</li>
 *   <li>{@link BlockchainFactory}: A factory for creating instances of blockchain-specific implementations.</li>
 * </ul>
 *
 * @since 1.0
 */
@Configuration
public class DefaultConfiguration {

    /**
     * Creates and configures a {@link BlockchainHttpClient} bean.
     * This bean is used to send HTTP requests to blockchain networks.
     *
     * @return An instance of {@link DefaultBlockchainHttpClient}.
     */
    @Bean
    public BlockchainHttpClient blockchainHttpClient() {
        return new DefaultBlockchainHttpClient();
    }

    /**
     * Creates and configures a {@link MainnetConfiguration} bean.
     * This bean holds configuration properties for multiple blockchain networks,
     * such as Base, Ethereum, Solana, and Polygon.
     *
     * @return An instance of {@link MainnetConfiguration}.
     */
    @Bean
    public MainnetConfiguration mainnetConfig() {
        return new MainnetConfiguration();
    }

    /**
     * Creates and configures a {@link BlockchainFactory} bean.
     * This bean is used to create instances of blockchain-specific implementations
     * based on the provided configuration and HTTP client.
     *
     * @param httpClient           The {@link BlockchainHttpClient} bean for making HTTP requests.
     * @param mainnetConfiguration The {@link MainnetConfiguration} bean holding blockchain settings.
     * @return An instance of {@link DefaultBlockchainFactory}.
     */
    @Bean
    public BlockchainFactory blockchainFactory(BlockchainHttpClient httpClient, MainnetConfiguration mainnetConfiguration) {
        return new DefaultBlockchainFactory(httpClient, mainnetConfiguration);
    }

}