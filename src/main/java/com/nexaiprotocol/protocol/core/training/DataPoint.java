package com.nexaiprotocol.protocol.core.training;


import java.util.List;

/**
 * Interface representing a single data point in a dataset.
 * Provides methods to access the features and labels of the data point.
 *
 * @since 1.0
 */
public interface DataPoint {
    /**
     * Returns the list of feature values for this data point.
     * Features are the input variables used to make predictions.
     *
     * @return a list of feature values (e.g., [0.5, 1.2, -3.4])
     */
    List<Double> getFeatures();

    /**
     * Returns the label (target value) for this data point.
     * Labels are the ground truth values the model aims to predict during training.
     *
     * @return the label value (e.g., 1.0 for classification, 42.5 for regression)
     */
    double getLabel();
}