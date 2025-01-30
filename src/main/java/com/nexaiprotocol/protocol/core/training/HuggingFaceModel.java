package com.nexaiprotocol.protocol.core.training;


/**
 * Interface for loading and using pre-trained models from Hugging Face.
 * Provides methods for loading models and making predictions.
 *
 * @since 1.0
 */
public interface HuggingFaceModel {
    /**
     * Loads a pre-trained model from Hugging Face.
     *
     * @param modelName the name of the model on Hugging Face
     */
    void loadModel(String modelName);

    /**
     * Predicts the output for a given input text.
     *
     * @param inputText the input text
     * @return the prediction result
     */
    Prediction predict(String inputText);
}
