package com.nexaiprotocol.protocol.core.privacy.exception;

import com.nexaiprotocol.protocol.core.privacy.PrivacyProcessor;
import com.nexaiprotocol.protocol.core.privacy.SecureHashAlgorithm;
import lombok.Getter;

import java.io.PrintWriter;
import java.io.Serial;
import java.io.StringWriter;
import java.time.Instant;

/**
 * Indicates misconfiguration or invalid parameters in cryptographic operations.
 * Signals potential security vulnerabilities due to improper crypto settings.
 *
 * <h2>Common Causes</h2>
 * <ul>
 *   <li>Unsupported algorithm specifications</li>
 *   <li>Invalid key lengths</li>
 *   <li>Incompatible encryption modes</li>
 *   <li>Expired or revoked certificates</li>
 *   <li>Insecure parameter combinations</li>
 * </ul>
 *
 * <h2>Security Impact</h2>
 * <ul>
 *   <li>Potential weak cryptography risks</li>
 *   <li>Possible compliance violations</li>
 *   <li>Risk of cryptographic protocol downgrade</li>
 * </ul>
 *
 * @see PrivacyProcessor
 * @see SecureHashAlgorithm
 * @since 1.0
 */
@Getter
public class CryptoConfigurationException extends Exception {

    @Serial
    private static final long serialVersionUID = -2816921107375780493L;
    /**
     * -- GETTER --
     *
     * @return Name of the misconfigured parameter
     */
    private final String configParameter;
    /**
     * -- GETTER --
     *
     * @return Affected cryptographic algorithm
     */
    private final String algorithm;
    /**
     * -- GETTER --
     *
     * @return Recommended secure value
     */
    private final String expectedValue;
    /**
     * -- GETTER --
     *
     * @return Detected invalid value
     */
    private final String actualValue;

    /**
     * Constructs exception with cryptographic context
     *
     * @param message         Human-readable error description
     * @param configParameter Problematic configuration parameter name
     * @param algorithm       Affected cryptographic algorithm
     * @param expectedValue   Recommended secure value
     * @param actualValue     Detected invalid value
     * @param cause           Root cause exception (e.g., NoSuchAlgorithmException)
     */
    public CryptoConfigurationException(String message,
                                        String configParameter,
                                        String algorithm,
                                        String expectedValue,
                                        String actualValue,
                                        Throwable cause) {
        super(message, cause);
        this.configParameter = configParameter;
        this.algorithm = algorithm;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    /**
     * Simplified constructor for algorithm errors
     */
    public CryptoConfigurationException(String algorithm, Throwable cause) {
        this("Unsupported cryptographic algorithm: " + algorithm,
                "algorithm",
                algorithm,
                "NIST-recommended cipher",
                algorithm,
                cause);
    }

    /**
     * Generates security diagnostic report
     *
     * @return Structured forensic information
     */
    public String getForensicReport() {
        return String.format(
                "Crypto Configuration Failure Report\n" +
                        "===================================\n" +
                        "Timestamp: %s\n" +
                        "Parameter: %s\n" +
                        "Algorithm: %s\n" +
                        "Expected: %s\n" +
                        "Actual: %s\n" +
                        "Root Cause: %s\n" +
                        "Stack Trace:\n%s",
                Instant.now().toString(),
                configParameter,
                algorithm,
                expectedValue,
                actualValue,
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