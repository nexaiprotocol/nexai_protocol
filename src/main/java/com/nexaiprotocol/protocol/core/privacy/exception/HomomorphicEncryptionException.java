package com.nexaiprotocol.protocol.core.privacy.exception;


import java.io.Serial;

/**
 * Custom exception for homomorphic operation failures
 *
 * @since 1.0
 */

public class HomomorphicEncryptionException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5525450282944436298L;

    public HomomorphicEncryptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
