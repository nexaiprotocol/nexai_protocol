package com.nexaiprotocol.common.exception;


import java.io.Serial;

/**
 * Custom exception class for data access-related errors.
 * This exception is thrown when an error occurs while accessing or manipulating data,
 * such as database operations or data persistence issues.
 *
 * @since 1.0
 */
public class DataAccessException extends Exception {

    /**
     * Constructs a new DataAccessException with no detail message.
     */
    public DataAccessException() {
        super();
    }

    /**
     * Constructs a new DataAccessException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public DataAccessException(String message) {
        super(message);
    }

    /**
     * Constructs a new DataAccessException with the specified detail message and cause.
     *
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (typically another throwable).
     */
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DataAccessException with the specified cause.
     *
     * @param cause The cause of the exception (typically another throwable).
     */
    public DataAccessException(Throwable cause) {
        super(cause);
    }
}