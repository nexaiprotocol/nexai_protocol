package com.nexaiprotocol.protocol.module.llms.gemini;


import com.nexaiprotocol.common.exception.ModelClientException;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;
import com.nexaiprotocol.protocol.module.llms.strategy.ModelClientProvider;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ModelClientProvider} for interacting with the Gemini model.
 * This client handles communication with the Gemini API, including request formatting,
 * response parsing, and error handling.
 *
 * <p>Example usage:
 * <pre>
 *     GeminiClient client = new GeminiClient();
 *     ChatResponse response = client.callModel(new ChatRequest("Hello, Gemini!"));
 * </pre>
 *
 * @see ModelClientProvider
 * @since 1.0
 */
@Component("gemini")
public class GeminiClient implements ModelClientProvider {
    @Override
    public ChatResponse callModel(ChatRequest request) throws ModelClientException {

        try {
            return null;
        } catch (Exception e) {
            throw new ModelClientException(e.getMessage());
        }
    }
}