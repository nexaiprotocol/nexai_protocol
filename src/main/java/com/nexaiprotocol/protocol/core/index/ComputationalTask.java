package com.nexaiprotocol.protocol.core.index;

import lombok.Data;

import java.util.Map;

/**
 * ComputationalTask Class
 * <p>
 * Represents a computational task that can be submitted to the IndexProvider.
 *
 * @since 1.0
 */
@Data
public class ComputationalTask {
    private String taskId;
    private String taskType;
    private Map<String, Object> parameters;
}