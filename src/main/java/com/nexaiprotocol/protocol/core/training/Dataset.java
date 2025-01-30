package com.nexaiprotocol.protocol.core.training;


import java.util.List;

/**
 * Interface representing a dataset used for training or testing a model.
 * Provides methods to access and manipulate the data.
 *
 * @since 1.0
 */
public interface Dataset {
    /**
     * Returns all data points in the dataset.
     *
     * @return a list of {@link DataPoint} objects
     */
    List<DataPoint> getDataPoints();

    /**
     * Adds a new data point to the dataset.
     *
     * @param dataPoint the {@link DataPoint} to add
     */
    void addDataPoint(DataPoint dataPoint);

    /**
     * Randomizes the order of data points in the dataset.
     * Used to prevent bias during training.
     */
    void shuffle();
}
