package com.nexaiprotocol.common.exception;

import java.io.Serial;

/**
 * Custom exception class for authentication-related errors.
 * This exception is thrown when user authentication fails due to invalid credentials,
 * missing user information, or other authentication issues.
 *
 * @since 1.0
 */
public class AuthenticationException extends Exception {

    /**
     * Constructs a new AuthenticationException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * Constructs a new AuthenticationException with the specified detail message and cause.
     *
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (typically another throwable).
     */
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
