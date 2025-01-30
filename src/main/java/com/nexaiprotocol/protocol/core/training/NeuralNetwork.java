package com.nexaiprotocol.protocol.core.training;


import java.util.List;

/**
 * Interface representing a deep neural network model.
 * Defines methods for training, prediction, and accessing model parameters.
 *
 * @since 1.0
 */
public interface NeuralNetwork {
    /**
     * Trains the neural network using the provided dataset.
     *
     * @param dataset  the training data
     * @param config   the training configuration
     * @param callback the training callback for monitoring progress
     */
    void train(Dataset dataset, TrainingConfig config, TrainingCallback callback);

    /**
     * Predicts the output for a given data point.
     *
     * @param dataPoint the input data point
     * @return the prediction result
     */
    Prediction predict(DataPoint dataPoint);

    /**
     * Returns the weights of the neural network.
     *
     * @return a list of weight matrices for each layer
     */
    List<double[][]> getWeights();

    /**
     * Returns the biases of the neural network.
     *
     * @return a list of bias vectors for each layer
     */
    List<double[]> getBiases();
}
