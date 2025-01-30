package com.nexaiprotocol.common.exception;

import java.io.Serial;

/**
 * Custom exception class for handling errors that occur during prompt generation.
 * This exception can be thrown when there is an issue with generating a prompt,
 * such as invalid input parameters, missing data, or other runtime errors.
 *
 * @since 1.0
 */
public class PromptGenerationException extends Exception {


    /**
     * Constructs a new PromptGenerationException with no detail message.
     */
    public PromptGenerationException() {
        super();
    }

    /**
     * Constructs a new PromptGenerationException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public PromptGenerationException(String message) {
        super(message);
    }

    /**
     * Constructs a new PromptGenerationException with the specified detail message and cause.
     *
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (typically another throwable).
     */
    public PromptGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new PromptGenerationException with the specified cause.
     *
     * @param cause The cause of the exception (typically another throwable).
     */
    public PromptGenerationException(Throwable cause) {
        super(cause);
    }
}