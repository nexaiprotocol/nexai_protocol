package com.nexaiprotocol.protocol.core.privacy.exception;


import java.io.Serial;

/**
 * Indicates failures in differential privacy mechanisms
 *
 * @since 1.0
 */
public class DifferentialPrivacyException extends Exception {
    @Serial
    private static final long serialVersionUID = 4084677479247135850L;

    public DifferentialPrivacyException(String message, Throwable cause) {
        super(message, cause);
    }
}
