package com.nexaiprotocol.protocol.module.llms.strategy;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * A factory implementation for retrieving the appropriate {@link ModelClientProvider} strategy
 * based on the specified model name. This class uses a map of registered strategies to provide
 * the correct client for interacting with different AI models (e.g., ChatGPT, Ollama, Gemini, Claude).
 *
 * <p>This factory is designed to be flexible and extensible, allowing new model clients to be
 * added dynamically through dependency injection. It is typically used in conjunction with
 * Spring's dependency injection to manage the lifecycle of model clients.
 *
 * <p>Example usage:
 * <pre>
 *     // Assuming Spring context is initialized
 *     ModelProviderFactory factory = context.getBean(SimpleModelProviderFactory.class);
 *     ModelClientProvider provider = factory.getStrategy("chatgpt");
 *     ChatResponse response = provider.callModel(new ChatRequest("Hello!"));
 * </pre>
 *
 * @see ModelClientProvider
 * @see ModelProviderFactory
 * @since 1.0
 */
@Service
public class SimpleModelProviderFactory implements ModelProviderFactory {

    private final Map<String, ModelClientProvider> strategies;

    /**
     * Constructs a new {@link SimpleModelProviderFactory} with the provided strategies.
     * The strategies map is typically populated by Spring's dependency injection,
     * where the keys are model names (e.g., "chatgpt", "ollama") and the values are
     * the corresponding {@link ModelClientProvider} implementations.
     *
     * @param strategies A map of model names to their respective {@link ModelClientProvider} implementations
     */
    public SimpleModelProviderFactory(Map<String, ModelClientProvider> strategies) {
        this.strategies = strategies;
    }

    /**
     * Retrieves the {@link ModelClientProvider} strategy associated with the specified model name.
     * The model name is case-insensitive, as it is converted to lowercase before lookup.
     *
     * @param model The name of the model (e.g., "chatgpt", "ollama", "gemini", "claude")
     * @return The {@link ModelClientProvider} implementation for the specified model,
     * or {@code null} if no strategy is found for the given model name
     */
    @Override
    public ModelClientProvider getStrategy(String model) {
        return strategies.get(model.toLowerCase());
    }
}
