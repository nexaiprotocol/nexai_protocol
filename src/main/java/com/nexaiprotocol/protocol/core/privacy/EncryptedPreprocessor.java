package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.HomomorphicEncryptionException;
import com.nexaiprotocol.protocol.core.privacy.exception.SecureProcessingException;
import com.nexaiprotocol.protocol.core.privacy.constant.FeatureScaling;
import com.nexaiprotocol.protocol.core.privacy.constant.MissingValueHandling;
import com.nexaiprotocol.protocol.core.privacy.config.PreprocessingConfig;


/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Homomorphic-compatible preprocessing executor
 *
 * @since 1.0
 */
public class EncryptedPreprocessor {
    private final PrivacyProcessor privacyProcessor;
    private final double maxScalingFactor;

    public EncryptedPreprocessor(PrivacyProcessor privacyProcessor, double maxScalingFactor) {
        this.privacyProcessor = privacyProcessor;
        this.maxScalingFactor = maxScalingFactor;
    }

    /**
     * Apply configured preprocessing to encrypted data
     *
     * @param encryptedInput Source encrypted data
     * @param config         Preprocessing configuration
     * @return Processed encrypted data
     * @throws SecureProcessingException If security constraints are violated
     */
    public EncryptedData process(EncryptedData encryptedInput, PreprocessingConfig config) throws SecureProcessingException {
        //  getFeatureScaling work flow
        switch (config.getFeatureScaling()) {
            case FIXED_FACTOR:
                return scaleWithFixedFactor(encryptedInput, 1000.0);
            case DECIMAL_SCALING:
                return applyDecimalScaling(encryptedInput, 3); // 10^3
            //todo
        }
        return encryptedInput;
    }

    private EncryptedData handleMissingValues(EncryptedData data, MissingValueHandling strategy)
            throws SecureProcessingException {
        switch (strategy) {
            case FILL_ZERO:
                return privacyProcessor.scalarAdd(0.0, data);

            case FLAG_VALUE:
                // 假设-999为特殊标记值
                return privacyProcessor.scalarAdd(-999.0, data);

            case KEEP:
                return data;

            default:
                throw new SecureProcessingException(
                        "Unsupported missing value strategy for encrypted data: " + strategy
                );
        }
    }

    private EncryptedData applyFeatureScaling(EncryptedData data, FeatureScaling method)
            throws SecureProcessingException {

        switch (method) {
            case FIXED_FACTOR:
                return scaleWithFixedFactor(data, 1000.0);

            case DECIMAL_SCALING:
                return scaleWithFixedFactor(data, Math.pow(10, 3));

            case NONE:
                return data;

            default:
                throw new SecureProcessingException(
                        "Statistical scaling requires plaintext operations: " + method
                );
        }
    }

    private EncryptedData flagMissingValues(EncryptedData data, double flagValue)
            throws SecureProcessingException {
        try {

            return privacyProcessor.scalarAdd(flagValue, data);
        } catch (HomomorphicEncryptionException e) {
            throw new SecureProcessingException("Failed to mark missing values:", e);
        }
    }


    private EncryptedData applyDecimalScaling(EncryptedData data, int decimalPlaces)
            throws SecureProcessingException {
        double factor = Math.pow(10, decimalPlaces);
        return scaleWithFixedFactor(data, factor);
    }

    private EncryptedData scaleWithFixedFactor(EncryptedData data, double factor)
            throws SecureProcessingException {
        if (Math.abs(factor) > maxScalingFactor) {
            throw new SecureProcessingException(
                    "Scaling factor exceeds the safety limit: " + factor + " > " + maxScalingFactor
            );
        }
        try {
            return privacyProcessor.scalarMultiply(factor, data);
        } catch (HomomorphicEncryptionException e) {
            throw new SecureProcessingException("Fixed scaling factor failed", e);
        }
    }

    private EncryptedData handleStatisticalScaling(EncryptedData data, FeatureScaling method) throws SecureProcessingException {
        //Todo
        return null;
    }

}