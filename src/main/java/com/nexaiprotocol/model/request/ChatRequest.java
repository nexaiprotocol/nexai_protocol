package com.nexaiprotocol.model.request;


import com.nexaiprotocol.protocol.module.llms.strategy.ModelClientProvider;
import lombok.Data;

/**
 * Represents a request to an AI model for generating a chat-based response.
 * This class encapsulates the input data required by the model, including the user's prompt
 * and the specific model to be used for processing the request.
 *
 * <p>Typical usage includes:
 * <pre>
 *     ChatRequest request = new ChatRequest();
 *     request.setPrompt("Who are you?");
 *     request.setModel("chatgpt");
 *     ChatResponse response = modelClient.callModel(request);
 * </pre>
 *
 * <p>Fields:
 * <ul>
 *   <li>{@code prompt}: The user's input or question to be processed by the model.</li>
 *   <li>{@code model}: The name of the AI model to be used (e.g., "chatgpt", "ollama", "gemini").</li>
 * </ul>
 *
 * @Data Lombok annotation to automatically generate getters, setters, toString, equals, and hashCode methods
 * @see ChatResponse
 * @see ModelClientProvider
 * @since 1.0
 */
@Data
public class ChatRequest {
    /**
     * The user's input or question to be processed by the AI model.
     * This field is required and should contain the text that the model will respond to.
     */
    private String prompt;

    /**
     * The name of the AI model to be used for processing the request.
     * This field is optional and can be used to specify a particular model (e.g., "chatgpt", "ollama").
     * If not provided, the default model configured in the client implementation will be used.
     */
    private String model;
}