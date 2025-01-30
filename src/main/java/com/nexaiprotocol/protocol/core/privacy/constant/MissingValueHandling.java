package com.nexaiprotocol.protocol.core.privacy.constant;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Strategies for handling missing values in encrypted data
 *
 * @since 1.0
 */
public enum MissingValueHandling {
    /**
     * Remove samples with missing values
     */
    DROP_SAMPLES,

    /**
     * Remove features with missing values
     */
    DROP_FEATURES,

    /**
     * Fill missing values with zero (ciphertext additive identity)
     */
    FILL_ZERO,

    /**
     * Fill with mean value (requires plaintext computation)
     */
    FILL_MEAN,

    /**
     * Fill with median value (requires plaintext computation)
     */
    FILL_MEDIAN,

    /**
     * Fill with mode value (requires plaintext computation)
     */
    FILL_MODE,

    /**
     * Mark missing values with special flags
     */
    FLAG_VALUE,

    /**
     * Keep missing values as-is
     */
    KEEP
}

