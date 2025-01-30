package com.nexaiprotocol.common.config.chat;


import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since 1.0
 */

@Configuration
public class ChatClientConfiguration {

    @Bean(name = "openAiChatClient")
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel).build();
    }

    @Bean(name = "anthropicChatClient")
    public ChatClient anthropicChatClient(AnthropicChatModel anthropicChatModel) {
        return ChatClient.builder(anthropicChatModel).build();
    }

    @Bean(name = "ollamaChatClient")
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).build();
    }

//    @Bean
//    public ChatClient vertexAiChatClient(VertexAiGeminiChatModel vertexAiGeminiChat) {
//        return ChatClient.builder(vertexAiGeminiChat).build();
//    }
}
