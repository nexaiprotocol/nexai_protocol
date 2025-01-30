package com.nexaiprotocol.common.result;


/**
 * @since 1.0
 */


public interface ResultCode {
    int SUCCESS = 200;
    int ERROR = 500;
    int VALIDATION_ERROR = 400;
    int INTERNAL_SERVER_ERROR = 500;
}
