package com.nexaiprotocol.api.v1.test;


import com.nexaiprotocol.common.result.ResponseResult;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;
import com.nexaiprotocol.protocol.core.chat.ChatModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @since 1.0
 */

@Tag(name = "Test Controller")
@RestController
@RequestMapping("/api/v1/ai/test")
public class TestChatController {

    private final ChatModelService chatModelService;

    public TestChatController(ChatModelService chatModelService) {
        this.chatModelService = chatModelService;
    }

    @Operation(summary = "Chat Test")
    @PostMapping("/test")
    public ResponseResult chatTest(@RequestParam String prompt) {
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("openai");
        chatRequest.setPrompt(prompt);
        ChatResponse chatResponse = this.chatModelService.callModel(chatRequest);
        Map<String, String> question = Map.of(
                "question", prompt,
                "answer", chatResponse.getResponse()
        );
        ResponseResult responseResult = ResponseResult.success().data("chat", question);
        return responseResult;
    }
}
