package com.nexaiprotocol.protocol.core.training;

/**
 * Unified interface for both local and Hugging Face models.
 * Provides methods for training, prediction, and model management.
 *
 * @since 1.0
 */
public interface UnifiedModel {
    /**
     * Trains the model using the provided dataset (for local models).
     *
     * @param dataset the training data
     */
    void train(Dataset dataset);

    /**
     * Predicts the output for a given input (text or data point).
     *
     * @param input the input (text or data point)
     * @return the prediction result
     */
    Prediction predict(Object input);

    /**
     * Saves the trained model to the specified path (for local models).
     *
     * @param modelPath the path to save the model
     */
    void saveModel(String modelPath);

    /**
     * Loads a pre-trained model from the specified path or Hugging Face.
     *
     * @param modelPathOrName the path or name of the model
     */
    void loadModel(String modelPathOrName);
}
