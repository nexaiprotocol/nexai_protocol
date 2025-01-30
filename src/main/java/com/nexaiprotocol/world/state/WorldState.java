package com.nexaiprotocol.world.state;


/**
 * The {@code WorldState} interface represents the state of the world within the system.
 * It defines the structure for managing and tracking the overall state of the simulated
 * environment, including properties such as time, resources, and global events.
 *
 * <p>This interface is designed to be implemented by classes that need to represent
 * and manage the dynamic state of the world, enabling functionalities like saving,
 * loading, and updating the world state.
 *
 * <p>Example usage:
 * <pre>
 *     public class MyWorldState implements WorldState {
 *         private String time;
 *         private Map<String, Object> resources;
 *         // Implement methods to manage world state
 *     }
 * </pre>
 *
 * @since 1.0
 */
public interface WorldState {
}
