package com.nexaiprotocol.protocol.core.index;


import java.util.List;

/**
 * IndexProvider Interface
 * <p>
 * This interface provides methods for distributed execution of complex computational tasks,
 * efficient retrieval of task results, and optimization of real-time task execution.
 *
 * @since 1.0
 */
public interface IndexProvider {

    /**
     * Submits a computational task to the distributed system for execution.
     *
     * @param task The computational task to be executed.
     * @return A unique task ID for tracking the task's progress and results.
     */
    String submitTask(ComputationalTask task);

    /**
     * Retrieves the result of a previously submitted task.
     *
     * @param taskId The unique ID of the task.
     * @return The result of the task, or null if the task is still pending or failed.
     */
    TaskResult getTaskResult(String taskId);

    /**
     * Cancels a running task.
     *
     * @param taskId The unique ID of the task to be canceled.
     * @return True if the task was successfully canceled, false otherwise.
     */
    boolean cancelTask(String taskId);

    /**
     * Optimizes the execution of real-time tasks by adjusting resource allocation.
     *
     * @param task The real-time task to be optimized.
     * @return True if the optimization was successful, false otherwise.
     */
    boolean optimizeRealTimeTask(RealTimeTask task);

    /**
     * Retrieves the status of a task.
     *
     * @param taskId The unique ID of the task.
     * @return The current status of the task (e.g., PENDING, RUNNING, COMPLETED, FAILED).
     */
    TaskStatus getTaskStatus(String taskId);

    /**
     * Searches for tasks based on specific criteria (e.g., task type, status, etc.).
     *
     * @param criteria The search criteria to filter tasks.
     * @return A list of tasks that match the criteria.
     */
    List<ComputationalTask> searchTasks(TaskSearchCriteria criteria);

    /**
     * Registers a callback to be notified when a task's status changes.
     *
     * @param taskId   The unique ID of the task.
     * @param callback The callback to be invoked on status change.
     */
    void registerStatusCallback(String taskId, TaskStatusCallback callback);

    /**
     * Unregisters a previously registered status callback.
     *
     * @param taskId   The unique ID of the task.
     * @param callback The callback to be unregistered.
     */
    void unregisterStatusCallback(String taskId, TaskStatusCallback callback);
}












