package com.nexaiprotocol.protocol.core.agent;


import com.nexaiprotocol.common.exception.PromptGenerationException;
import com.nexaiprotocol.model.entity.AgentEntity;
import com.nexaiprotocol.model.vo.AgentModelVo;

import java.util.Optional;

/**
 * Interfaces related to agent operation functions.
 * This service provides methods for creating and retrieving agent entities.
 *
 * @since 1.0
 */

public interface AgentBuilder {
    /**
     * Creates a new agent based on the provided {@link AgentModelVo}.
     * This method performs the following steps:
     * <ol>
     *   <li>Converts the agent details into a prompt for the AI model</li>
     *   <li>Calls the AI model to generate a response</li>
     *   <li>Saves the agent entity in the repository</li>
     *   <li>Updates the user's information with the new agent</li>
     *   <li>Records the agent creation on the blockchain</li>
     * </ol>
     *
     * @param agentModelVo The details of the agent to be created. Must not be null.
     * @return The created {@link AgentEntity} object, including system-generated details
     * @throws PromptGenerationException If an error occurs during prompt generation or AI model interaction
     * @throws IllegalArgumentException  If the provided {@link AgentModelVo} is invalid or missing required fields
     */
    AgentEntity creatAgent(AgentModelVo agentModelVo) throws PromptGenerationException;

    /**
     * Retrieves an agent by its unique identifier.
     *
     * @param id The unique identifier of the agent to retrieve. Must not be null or empty.
     * @return An {@link Optional} containing the {@link AgentEntity} if found, or an empty {@link Optional} if not
     * @throws IllegalArgumentException If the provided ID is null or empty
     */
    Optional<AgentEntity> getAgentById(String id);
}
