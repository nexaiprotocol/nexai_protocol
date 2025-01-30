package com.nexaiprotocol.protocol.core.index;


import lombok.Data;

/**
 * TaskResult Class
 * <p>
 * Represents the result of a computational task.
 *
 * @since 1.0
 */
@Data
public class TaskResult {
    private String taskId;
    private Object result;
    private TaskStatus status;
}