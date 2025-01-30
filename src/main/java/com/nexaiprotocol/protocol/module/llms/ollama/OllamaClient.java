package com.nexaiprotocol.protocol.module.llms.ollama;


import com.nexaiprotocol.common.exception.ModelClientException;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;
import com.nexaiprotocol.protocol.module.llms.strategy.ModelClientProvider;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ModelClientProvider} for interacting with the Ollama model.
 * This client handles communication with the Ollama API, including request formatting,
 * response parsing, and error handling.
 *
 * <p>Example usage:
 * <pre>
 *     OllamaClient client = new OllamaClient();
 *     ChatResponse response = client.callModel(new ChatRequest("Hello, Ollama!"));
 * </pre>
 *
 * @see ModelClientProvider
 * @since 1.0
 */
@Component("ollama")
public class OllamaClient implements ModelClientProvider {
    @Override
    public ChatResponse callModel(ChatRequest request) throws ModelClientException {
        //TODO
        return null;
    }
}
