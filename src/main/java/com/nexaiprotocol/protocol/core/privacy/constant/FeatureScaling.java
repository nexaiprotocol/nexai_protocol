package com.nexaiprotocol.protocol.core.privacy.constant;


/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Feature scaling/normalization methods compatible with HE operations
 *
 * @since 1.0
 */
public enum FeatureScaling {
    /**
     * No scaling applied
     */
    NONE,

    /**
     * Z-score standardization (x - μ)/σ
     * Requires plaintext statistics
     */
    Z_SCORE,

    /**
     * Min-Max scaling to [0,1] range
     * Requires plaintext min/max
     */
    MIN_MAX,

    /**
     * Robust scaling using IQR
     * Requires plaintext quartiles
     */
    ROBUST,

    /**
     * Logarithmic transformation
     * Must be applied pre-encryption
     */
    LOG_SCALE,

    /**
     * Homomorphic-friendly scaling by fixed factor
     * Example: Scale by 1000 and round to integers
     */
    FIXED_FACTOR,

    /**
     * Decimal scaling for integer preservation
     * x_scaled = x * 10^n
     */
    DECIMAL_SCALING
}