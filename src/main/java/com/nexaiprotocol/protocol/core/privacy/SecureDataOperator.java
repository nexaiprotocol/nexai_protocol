package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.config.PrivacyConfig;
import com.nexaiprotocol.protocol.core.privacy.config.PreprocessingConfig;

import java.util.List;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Coordinates secure data operations in distributed intelligence systems using privacy-preserving techniques.
 * Provides cryptographic tools for multi-party data processing while maintaining end-to-end encryption.
 *
 * <h2>Architectural Context</h2>
 * <pre>
 * ┌──────────────────────┐       ┌──────────────────────┐
 * │ SecureDataOperator   │<>-----│ PrivacyProcessor     │
 * │ (Interface)          │       │ (Core Crypto Engine) │
 * └──────────────────────┘       └──────────────────────┘
 *        ▲
 *        │ implements
 * ┌──────────────────────┐
 * │ FederatedDataOperator│
 * │ (Concrete Implementation)
 * └──────────────────────┘
 * </pre>
 *
 * @see PrivacyProcessor
 * @see EncryptedPreprocessor
 * @see HomomorphicTrainingModule
 * @since 1.0
 */
public interface SecureDataOperator {

    /**
     * Securely aggregates encrypted data from multiple sources
     *
     * @param encryptedDataList List of encrypted data batches
     * @return Aggregated encrypted result
     */
    EncryptedData secureAggregate(List<EncryptedData> encryptedDataList);

    /**
     * Processes encrypted data batch for model consumption
     *
     * @param encryptedBatch   Raw encrypted data samples
     * @param preprocessConfig Data transformation specifications
     * @return Processed encrypted features
     */
    List<EncryptedData> preprocessEncryptedBatch(
            List<EncryptedData> encryptedBatch,
            PreprocessingConfig preprocessConfig
    );

    /**
     * Secures model inference results with differential privacy
     *
     * @param encryptedResult Raw encrypted inference output
     * @param privacyParams   Differential privacy configuration
     * @return Privacy-protected encrypted result
     */
    EncryptedData applyDifferentialPrivacy(
            EncryptedData encryptedResult,
            PrivacyConfig privacyParams
    );
}