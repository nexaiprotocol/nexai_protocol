package com.nexaiprotocol.protocol.core.agent;


/**
 * Defines a high-level interface for operations that can be performed by an agent.
 * This interface serves as a base contract for agent-based systems, where an "agent"
 * represents an autonomous entity capable of performing tasks, making decisions, or
 * interacting with other components.
 *
 * <p>Implementations of this interface should define specific agent behaviors and
 * capabilities, such as:
 * <ul>
 *   <li>Task execution</li>
 *   <li>Decision-making logic</li>
 *   <li>Interaction with external systems or APIs</li>
 *   <li>State management and reporting</li>
 * </ul>
 *
 * <p>This interface is intentionally left abstract to allow for flexibility in
 * defining agent behavior across different use cases and domains.
 *
 * <p>Example usage:
 * <pre>
 *     AgentOperator agent = new TaskExecutionAgent();
 *     agent.execute(); // Assuming execute() is a method defined in a concrete implementation
 * </pre>
 *
 * @since 1.0
 */
public interface AgentOperator {
    // This interface is intentionally left empty to allow for flexible implementations.
    // Concrete implementations should define specific methods based on the agent's role.
}
