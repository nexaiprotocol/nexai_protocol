package com.nexaiprotocol.protocol.core.index;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * RealTimeTask Class
 * <p>
 * Represents a real-time task that requires optimization for execution.
 *
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RealTimeTask extends ComputationalTask {
    private int priority;
    private int deadline; // in milliseconds
}