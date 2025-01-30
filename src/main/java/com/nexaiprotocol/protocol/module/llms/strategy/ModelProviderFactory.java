package com.nexaiprotocol.protocol.module.llms.strategy;


/**
 * @since 1.0
 */


public interface ModelProviderFactory {
    /**
     * Retrieves the {@link ModelClientProvider} strategy associated with the specified model name.
     * The model name is case-insensitive, as it is converted to lowercase before lookup.
     *
     * @param model The name of the model (e.g., "chatgpt", "ollama", "gemini", "claude")
     * @return The {@link ModelClientProvider} implementation for the specified model,
     * or {@code null} if no strategy is found for the given model name
     */
    ModelClientProvider getStrategy(String model);
}
