package com.nexaiprotocol.protocol.core.privacy.exception;


import com.nexaiprotocol.protocol.core.privacy.impl.AuditTrail;
import com.nexaiprotocol.protocol.core.privacy.ImmutableStorage;
import lombok.Getter;

import java.io.Serial;
import java.time.Instant;

/**
 * Indicates failure to securely retrieve data from immutable storage systems.
 * Signals potential storage corruption, network issues, or verification failures.
 *
 * <h2>Common Causes</h2>
 * <ul>
 *   <li>Merkle proof verification failures</li>
 *   <li>Storage backend unavailability</li>
 *   <li>Data tampering detected</li>
 *   <li>Invalid content addressing identifiers</li>
 * </ul>
 *
 * @see ImmutableStorage
 * @see AuditTrail
 * @since 1.0
 */
@Getter
public class StorageReadException extends Exception {
    @Serial
    private static final long serialVersionUID = -3832516494151045938L;
    /**
     * -- GETTER --
     *
     * @return Problematic content identifier
     */
    private final String storageId;
    /**
     * -- GETTER --
     *
     * @return Storage backend type identifier
     */
    private final String storageType;

    /**
     * Constructs exception with forensic details
     *
     * @param message     Human-readable error description
     * @param storageId   Content identifier (e.g., CID, block hash)
     * @param storageType Backend type ("Blockchain", "S3", etc.)
     * @param cause       Root cause exception from storage client
     */
    public StorageReadException(String message,
                                String storageId,
                                String storageType,
                                Throwable cause) {
        super(message, cause);
        this.storageId = storageId;
        this.storageType = storageType;
    }

    /**
     * Generates forensic report for incident response
     *
     * @return Structured diagnostic information
     */
    public String getForensicReport() {
        return String.format(
                "Storage Read Failure\n" +
                        "====================\n" +
                        "Timestamp: %s\n" +
                        "Storage Type: %s\n" +
                        "Content ID: %s\n" +
                        "Root Cause: %s",
                Instant.now().toString(),
                storageType,
                storageId,
                getCause() != null ? getCause().getMessage() : "Unknown"
        );
    }
}
