package com.nexaiprotocol.protocol.core.training;


/**
 * Interface representing a training service provider.
 * Implementations handle the end-to-end training process.
 *
 * @since 1.0
 */
public interface TrainingProvider {
    /**
     * Trains a model using the provided dataset.
     *
     * @param dataset the training data
     */
    void train(Dataset dataset);
}