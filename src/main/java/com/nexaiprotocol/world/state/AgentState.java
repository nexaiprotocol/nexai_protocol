package com.nexaiprotocol.world.state;




/**
 * The {@code AgentState} interface extends {@link EntityState} and represents the state of an agent
 * within the system. It provides a foundation for defining agent-specific state attributes and behaviors,
 * enabling the tracking and management of agent statuses.
 *
 * <p>This interface is designed to be implemented by classes that need to represent the state of agents,
 * such as their activity, health, or other dynamic properties.
 *
 * <p>Example usage:
 * <pre>
 *     public class MyAgentState implements AgentState {
 *         private String status;
 *         // Implement methods from EntityState and AgentState
 *     }
 * </pre>
 *
 * @see EntityState
 * @since 1.0
 */
public interface AgentState extends EntityState {
}
