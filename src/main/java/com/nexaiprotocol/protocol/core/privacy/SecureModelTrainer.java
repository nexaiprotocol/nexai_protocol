package com.nexaiprotocol.protocol.core.privacy;


import java.util.List;
import java.util.Map;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Manages encrypted model training operations
 *
 * @since 1.0
 */
public interface SecureModelTrainer {

    /**
     * Initializes model parameters with homomorphic encryption
     *
     * @param parameterSpecs Map of parameter names to dimension specifications
     * @return Map of encrypted initial parameters
     */
    Map<String, EncryptedData> initializeEncryptedParameters(Map<String, int[]> parameterSpecs);

    /**
     * Executes forward propagation with encrypted inputs and parameters
     *
     * @param encryptedInput  Encrypted feature data
     * @param encryptedParams Current encrypted model parameters
     * @return Encrypted prediction results
     */
    EncryptedData encryptedForwardPass(EncryptedData encryptedInput, Map<String, EncryptedData> encryptedParams);

    /**
     * Computes encrypted gradients through backward propagation
     *
     * @param encryptedLoss        Encrypted loss value from forward pass
     * @param encryptedActivations List of encrypted layer activations
     * @return Map of encrypted parameter gradients
     */
    Map<String, EncryptedData> computeEncryptedGradients(
            EncryptedData encryptedLoss,
            List<EncryptedData> encryptedActivations
    );

    /**
     * Updates model parameters using encrypted gradients
     *
     * @param currentParams      Current encrypted parameters
     * @param encryptedGradients Encrypted gradient values
     * @param learningRate       Optimization step size
     * @return Updated encrypted parameters
     */
    Map<String, EncryptedData> updateEncryptedParameters(
            Map<String, EncryptedData> currentParams,
            Map<String, EncryptedData> encryptedGradients,
            double learningRate
    );
}