package com.nexaiprotocol.protocol.core.privacy.constant;


/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Categorizes security-critical operations for audit logging and compliance reporting.
 * Aligns with GDPR Article 30 record-keeping requirements.
 *
 * @since 1.0
 */
public enum AuditOperation {
    /**
     * Data encryption event
     */
    DATA_ENCRYPTION,

    /**
     * Data decryption event
     */
    DATA_DECRYPTION,

    /**
     * Missing value imputation operation
     */
    DATA_IMPUTATION,

    /**
     * Statistical computation on encrypted data
     */
    ENCRYPTED_ANALYTICS,

    /**
     * System error or security incident
     */
    SECURITY_INCIDENT,

    /**
     * Cryptographic key rotation
     */
    KEY_ROTATION,

    /**
     * Access control policy change
     */
    ACCESS_POLICY_UPDATE
}