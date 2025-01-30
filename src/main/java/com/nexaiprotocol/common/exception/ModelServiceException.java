package com.nexaiprotocol.common.exception;


import java.io.Serial;

/**
 * Custom exception for handling errors in AI model service implementations.
 * This exception is thrown when there is a failure in communicating with the AI model service.
 *
 * @since 1.0
 */
public class ModelServiceException extends RuntimeException {


    public ModelServiceException(String message) {
        super(message);
    }

    public ModelServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
