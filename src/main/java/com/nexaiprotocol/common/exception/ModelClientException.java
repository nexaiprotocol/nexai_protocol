package com.nexaiprotocol.common.exception;


import java.io.Serial;

/**
 * Custom exception for handling errors in model client implementations.
 *
 * @since 1.0
 */
public class ModelClientException extends RuntimeException {


    public ModelClientException(String message) {
        super(message);
    }

    public ModelClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
