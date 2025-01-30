package com.nexaiprotocol.protocol.core.training;

/**
 * Interface for fine-tuning machine learning models.
 * Provides methods to load a pre-trained model, fine-tune it on a dataset, and save the fine-tuned model.
 *
 * @since 1.0
 */
public interface FineTuning {
    /**
     * Loads a pre-trained model from the specified path.
     *
     * @param modelPath the path to the pre-trained model
     */
    void loadModel(String modelPath);

    /**
     * Fine-tunes the model on the provided dataset.
     *
     * @param dataset the dataset to fine-tune the model on
     */
    void fineTune(Dataset dataset);

    /**
     * Saves the fine-tuned model to the specified path.
     *
     * @param savePath the path to save the fine-tuned model
     */
    void saveModel(String savePath);
}
