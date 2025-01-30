package com.nexaiprotocol.protocol.module.llms.strategy;


import com.nexaiprotocol.common.exception.ModelClientException;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;

/**
 * Defines a provider interface for interacting with various AI model services.
 * Implementations of this interface handle communication with specific AI models,
 * such as OpenAI, Ollama, Gemini, and Claude, and provide a unified way to call
 * these models for chat-based responses.
 *
 * <p>Implementations should handle:
 * <ul>
 *   <li>Model-specific API communication</li>
 *   <li>Request/response serialization and deserialization</li>
 *   <li>Error handling and retries</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>
 *     ModelClientProvider provider = new OpenAIChatClient();
 *     ChatRequest request = new ChatRequest();
 *     request.setPrompt("What is the capital of US?");
 *     ChatResponse response = provider.callModel(request);
 *     System.out.println(response.getOutput());
 * </pre>
 *
 * @see ChatRequest
 * @see ChatResponse
 * @since 1.0
 */
public interface ModelClientProvider {
    /**
     * Calls the AI model service with the provided request and returns the chat response.
     * This method is responsible for sending the input prompt to the model and retrieving
     * the generated output.
     *
     * @param request The chat request containing the input prompt and optional model name
     * @return The chat response containing the model's output
     * @throws ModelClientException If the request fails or the model service is unavailable
     */
    ChatResponse callModel(ChatRequest request) throws ModelClientException;
}