package com.nexaiprotocol.protocol.core.training;

/**
 * Interface representing training configuration parameters.
 *
 * @since 1.0
 */
public interface TrainingConfig {
    /**
     * Returns the learning rate for gradient-based optimization.
     *
     * @return the learning rate (e.g., 0.01)
     */
    double getLearningRate();

    /**
     * Returns the total number of training epochs.
     *
     * @return the number of epochs (e.g., 100)
     */
    int getEpochs();

    /**
     * Returns the batch size for mini-batch training.
     *
     * @return the batch size (e.g., 32)
     */
    int getBatchSize();
}