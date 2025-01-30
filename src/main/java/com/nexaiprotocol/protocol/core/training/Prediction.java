package com.nexaiprotocol.protocol.core.training;


import java.util.Map;

/**
 * Interface representing the result of a prediction made by a machine learning model.
 * This interface defines methods to access the predicted value and any additional metadata
 * associated with the prediction, such as confidence scores or probabilities.
 *
 * @since 1.0
 */
public interface Prediction {

    /**
     * Returns the predicted value.
     * This could be a class label for classification tasks or a continuous value for regression tasks.
     *
     * @return the predicted value
     */
    Object getPredictedValue();

    /**
     * Returns the confidence score or probability associated with the prediction.
     * This is typically used in classification tasks to indicate how confident the model is in its prediction.
     *
     * @return the confidence score or probability
     */
    double getConfidence();

    /**
     * Returns additional metadata associated with the prediction.
     * This could include things like feature importance, prediction intervals, or other model-specific information.
     *
     * @return a map of additional metadata
     */
    Map<String, Object> getMetadata();

    /**
     * Returns a human-readable representation of the prediction.
     * This could include the predicted value, confidence score, and any relevant metadata.
     *
     * @return a string representation of the prediction
     */
    String toString();
}