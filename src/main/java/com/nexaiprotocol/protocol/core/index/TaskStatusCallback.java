package com.nexaiprotocol.protocol.core.index;

/**
 * TaskStatusCallback Interface
 * <p>
 * Represents a callback to be invoked when a task's status changes.
 *
 * @since 1.0
 */
public interface TaskStatusCallback {
    void onStatusChange(String taskId, TaskStatus newStatus);
}