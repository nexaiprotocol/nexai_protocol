package com.nexaiprotocol.protocol.core.privacy.exception;


import java.io.Serial;

/**
 * Custom exception for secure processing failures
 *
 * @since 1.0
 */
public class SecureProcessingException extends Exception {
    @Serial
    private static final long serialVersionUID = 6965898061498690669L;

    public SecureProcessingException(String message) {
        super(message);
    }

    public SecureProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}