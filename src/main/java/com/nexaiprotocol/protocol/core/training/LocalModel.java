package com.nexaiprotocol.protocol.core.training;


import java.util.List;

/**
 * Interface representing a machine learning model.
 * Defines basic operations like training and prediction.
 */
public interface LocalModel {
    /**
     * Trains the model using the provided dataset.
     *
     * @param dataset the training data containing features and labels
     */
    void train(Dataset dataset);

    /**
     * Generates a prediction for a single data point.
     *
     * @param dataPoint the input data point with features
     * @return the {@link Prediction} result (e.g., class label or regression value)
     */
    Prediction predict(DataPoint dataPoint);

    /**
     * Returns the weights (coefficients) of the model.
     * Weights represent the learned parameters of the model, which are used to make predictions.
     * For example, in linear regression, weights correspond to the coefficients of the features.
     *
     * @return a list of weights, where each weight corresponds to a feature in the model
     */
    List<Double> getWeights();

    /**
     * Saves the trained model to the specified path.
     *
     * @param modelPath the path to save the model
     */
    void saveModel(String modelPath);

    /**
     * Loads a pre-trained model from the specified path.
     *
     * @param modelPath the path to the model
     */
    void loadModel(String modelPath);
}