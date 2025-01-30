package com.nexaiprotocol.protocol.core.privacy.config;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Differential privacy configuration parameters
 *
 * @since 1.0
 */
public class PrivacyConfig {
    private double epsilon;
    private double delta;
    private double sensitivity;
    private NoiseType noiseType;
    private ClippingBounds clipping;
    private AggregationParams aggregation;
    private double privacyBudgetWeight;

    private PrivacyConfig(Builder builder) {
        this.epsilon = builder.epsilon;
        this.delta = builder.delta;
        this.sensitivity = builder.sensitivity;
        this.noiseType = builder.noiseType;
        this.clipping = builder.clipping;
        this.aggregation = builder.aggregation;
        this.privacyBudgetWeight = builder.privacyBudgetWeight;

        validateParameters();
    }

    private void validateParameters() {
        if (epsilon <= 0 || delta < 0 || delta >= 1) {
            throw new IllegalArgumentException("Invalid (ε,δ)-DP parameters");
        }
        if (sensitivity <= 0) {
            throw new IllegalArgumentException("Sensitivity must be positive");
        }
    }

    /**
     * Noise distribution types
     */
    public enum NoiseType {
        LAPLACE, GAUSSIAN, EXPONENTIAL
    }

    /**
     * Value clipping boundaries
     */
    public static class ClippingBounds {
        private final double lower;
        private final double upper;

        public ClippingBounds(double lower, double upper) {
            if (lower >= upper) {
                throw new IllegalArgumentException("Invalid clipping bounds");
            }
            this.lower = lower;
            this.upper = upper;
        }
    }

    /**
     * Aggregation parameters
     */
    public static class AggregationParams {
        private final int minParticipants;
        private final double secureAggregationThreshold;

        public AggregationParams(int minParticipants, double threshold) {
            if (minParticipants < 1 || threshold <= 0) {
                throw new IllegalArgumentException("Invalid aggregation parameters");
            }
            this.minParticipants = minParticipants;
            this.secureAggregationThreshold = threshold;
        }
    }

    // Builder pattern implementation
    public static class Builder {
        private double epsilon = 1.0;
        private double delta = 1e-5;
        private double sensitivity = 1.0;
        private NoiseType noiseType = NoiseType.LAPLACE;
        private ClippingBounds clipping = new ClippingBounds(-10.0, 10.0);
        private AggregationParams aggregation = new AggregationParams(3, 0.9);
        private double privacyBudgetWeight = 1.0;

        public Builder setEpsilon(double epsilon) {
            this.epsilon = epsilon;
            return this;
        }

        public Builder setDelta(double delta) {
            this.delta = delta;
            return this;
        }

        // Other setters...

        public PrivacyConfig build() {
            return new PrivacyConfig(this);
        }
    }

    // Getters...
}