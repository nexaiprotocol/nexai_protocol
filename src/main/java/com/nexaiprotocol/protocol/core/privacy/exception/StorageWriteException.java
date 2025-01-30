package com.nexaiprotocol.protocol.core.privacy.exception;


import com.nexaiprotocol.protocol.core.privacy.ImmutableStorage;
import lombok.Getter;

import java.io.PrintWriter;
import java.io.Serial;
import java.io.StringWriter;
import java.time.Instant;

/**
 * Indicates failure to securely persist data to immutable storage systems.
 * Signals potential write conflicts, permission issues, or storage backend failures.
 *
 * <h2>Common Causes</h2>
 * <ul>
 *   <li>Write conflict in distributed systems</li>
 *   <li>Insufficient storage permissions</li>
 *   <li>Network partitioning events</li>
 *   <li>Storage quota exceeded</li>
 *   <li>Immutability policy violations</li>
 * </ul>
 *
 * @see ImmutableStorage
 * @since 1.0
 */
@Getter
public class StorageWriteException extends Exception {
    @Serial
    private static final long serialVersionUID = -1700569542706646160L;
    /**
     * -- GETTER --
     *
     * @return Target content identifier for failed write
     */
    private final String storageId;
    /**
     * -- GETTER --
     *
     * @return Storage backend type identifier
     */
    private final String storageType;
    /**
     * -- GETTER --
     *
     * @return SHA-256 hash of the failed payload
     */
    private final String attemptedDataHash;

    /**
     * Constructs exception with operational context
     *
     * @param message           Human-readable error description
     * @param storageId         Target content identifier (e.g., proposed block hash)
     * @param storageType       Backend type ("Blockchain", "S3", etc.)
     * @param attemptedDataHash Cryptographic hash of failed write payload
     * @param cause             Root cause from storage client
     */
    public StorageWriteException(String message,
                                 String storageId,
                                 String storageType,
                                 String attemptedDataHash,
                                 Throwable cause) {
        super(message, cause);
        this.storageId = storageId;
        this.storageType = storageType;
        this.attemptedDataHash = attemptedDataHash;
    }

    /**
     * Generates forensic report for incident analysis
     *
     * @return Structured diagnostic information
     */
    public String getForensicReport() {
        return String.format(
                "Storage Write Failure Report\n" +
                        "============================\n" +
                        "Timestamp: %s\n" +
                        "Storage Type: %s\n" +
                        "Target ID: %s\n" +
                        "Data Hash: %s\n" +
                        "Root Cause: %s\n" +
                        "Stack Trace:\n%s",
                Instant.now().toString(),
                storageType,
                storageId,
                attemptedDataHash,
                getCause() != null ? getCause().getMessage() : "Unknown",
                getStackTraceAsString()
        );
    }

    private String getStackTraceAsString() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.printStackTrace(pw);
        return sw.toString();
    }
}
