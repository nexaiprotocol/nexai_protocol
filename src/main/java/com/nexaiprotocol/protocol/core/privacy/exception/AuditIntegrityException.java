package com.nexaiprotocol.protocol.core.privacy.exception;


import com.nexaiprotocol.protocol.core.privacy.impl.AuditTrail;

import java.io.Serial;

/**
 * Indicates failure to verify cryptographic integrity of audit records.
 * Signals potential tampering or system compromise.
 *
 * @see AuditTrail#verifyLogIntegrity()
 * @since 1.0
 */
public class AuditIntegrityException extends SecurityException {
    @Serial
    private static final long serialVersionUID = -185987495912570300L;
    private final String compromisedHash;
    private final String expectedHash;

    /**
     * @param message         Human-readable error description
     * @param compromisedHash Detected invalid hash value
     * @param expectedHash    Expected valid hash value
     */
    public AuditIntegrityException(String message, String compromisedHash, String expectedHash) {
        super(message);
        this.compromisedHash = compromisedHash;
        this.expectedHash = expectedHash;
    }

    /**
     * @return Forensic evidence for incident investigation
     */
    public String getForensicEvidence() {
        return String.format("Hash mismatch: Found %s vs Expected %s",
                compromisedHash, expectedHash);
    }
}
