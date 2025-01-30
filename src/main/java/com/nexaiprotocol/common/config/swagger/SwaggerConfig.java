package com.nexaiprotocol.common.config.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title("NexAI Protocol API")
                        .description("NexAI Protocol API")
                        .contact(new Contact().name("NexAI").url("nexaiprotocol.com").email("help@nexaiprotocol.com"))
                        .version("v1"))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("External Doc")
                                .url("https://springshop.wiki.github.org/docs"));
    }

    @Bean
    public GroupedOpenApi allAPI() {
        return GroupedOpenApi.builder()
                .group("All")
                .pathsToMatch("/**")
                .packagesToScan("com.nexaiprotocol")
                .build();
    }

    @Bean
    public GroupedOpenApi testAPI() {
        return GroupedOpenApi.builder()
                .group("Test API")
                .pathsToMatch("/api/test/**")
                .packagesToScan("com.nexaiprotocol")
                .build();
    }


    @Bean
    public GroupedOpenApi agentAPIv1() {
        return GroupedOpenApi.builder()
                .group("Agent API")
                .pathsToMatch("/api/v1/ai/**")
                .packagesToScan("com.nexaiprotocol")
                .build();
    }
}
