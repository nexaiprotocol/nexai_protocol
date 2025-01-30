package com.nexaiprotocol.api.v1.test;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @since 1.0
 */

@Log4j2
@Tag(name = "Test OpenAI Controller")
@RestController
@RequestMapping("/api/ai/v1/test")
public class TestOpenAIController {

    private final ChatClient openAiChatClient;

    public TestOpenAIController(
            @Qualifier("openAiChatClient")
            ChatClient openAiChatClient
    ) {
        this.openAiChatClient = openAiChatClient;
    }

    @PostMapping("/chat/openai")
    public Map<String, String> chatWithOpenAi(@RequestBody String prompt) {
        String response = openAiChatClient.prompt().user(prompt).call().content();
        assert response != null;
        return Map.of("question", prompt, "answer", response);
    }
}