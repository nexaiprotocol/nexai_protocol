package com.nexaiprotocol.protocol.core.privacy.exception;


import java.io.Serial;

/**
 * Indicates errors in secure statistical computations
 *
 * @since 1.0
 */
public class SecureComputationException extends Exception {
    @Serial
    private static final long serialVersionUID = 5446650532957427102L;

    public SecureComputationException(String message, Throwable cause) {
        super(message, cause);
    }
}
