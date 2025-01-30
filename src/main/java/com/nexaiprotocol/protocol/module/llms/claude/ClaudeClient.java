package com.nexaiprotocol.protocol.module.llms.claude;

import com.nexaiprotocol.common.exception.ModelClientException;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;
import com.nexaiprotocol.protocol.module.llms.strategy.ModelClientProvider;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ModelClientProvider} for interacting with the Claude model.
 * This client handles communication with the Claude API, including request formatting,
 * response parsing, and error handling.
 *
 * <p>Example usage:
 * <pre>
 *     ClaudeClient client = new ClaudeClient();
 *     ChatResponse response = client.callModel(new ChatRequest("Hello, Claude!"));
 * </pre>
 *
 * @see ModelClientProvider
 * @since 1.0
 */
@Component("claude")
public class ClaudeClient implements ModelClientProvider {
    @Override
    public ChatResponse callModel(ChatRequest request) throws ModelClientException {
        //TODO
        return null;
    }
}
