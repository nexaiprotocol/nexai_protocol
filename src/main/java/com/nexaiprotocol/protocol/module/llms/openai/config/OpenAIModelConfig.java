package com.nexaiprotocol.protocol.module.llms.openai.config;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @since 1.0
 */

@Log4j2
@Getter
@Configuration
//@PropertySource("classpath:application.yml")
public class OpenAIModelConfig {
    @Value("${ai.chatgpt.api-url}")
    private String chatGptApiUrl;

    @Value("${ai.chatgpt.api-key}")
    private String chatGptApiKey;

    @Value("${ai.chatgpt.model}")
    private String chatGptModel;

    @PostConstruct
    public void checkConfig() {
//        log.info("ChatGPT API URL:{}", chatGptApiUrl);
    }
}
