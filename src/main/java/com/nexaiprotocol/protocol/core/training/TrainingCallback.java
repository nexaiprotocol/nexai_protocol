package com.nexaiprotocol.protocol.core.training;


/**
 * Interface representing a callback during the training process.
 * Handles events like the start/end of an epoch.
 *
 * @since 1.0
 */
public interface TrainingCallback {
    /**
     * Called at the start of a training epoch.
     *
     * @param epoch the current epoch number (starting from 0)
     */
    void onEpochStart(int epoch);

    /**
     * Called at the end of a training epoch.
     *
     * @param epoch the current epoch number
     * @param loss  the computed loss value for this epoch
     */
    void onEpochEnd(int epoch, double loss);
}