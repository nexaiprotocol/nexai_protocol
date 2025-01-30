package com.nexaiprotocol.common.exception;


import com.nexaiprotocol.common.result.ResultCode;
import com.nexaiprotocol.common.result.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @since 1.0
 */
@Log4j2
@RestControllerAdvice(basePackages = "com.*")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseResult> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            log.debug("Validation error - Field: {}, Message: {}", error.getField(), error.getDefaultMessage());
        });

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ResponseResult responseResult = ResponseResult.error()
                .code(ResultCode.VALIDATION_ERROR)
                .msg(errorMessage)
                .data("errors", ex.getBindingResult().getFieldErrors());

        return ResponseEntity.badRequest().body(responseResult);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult> handleGenericExceptions(Exception ex) {
        // Handle all other exceptions
        ResponseResult responseResult = ResponseResult.error()
                // Use a custom error code for internal errors
                .code(ResultCode.INTERNAL_SERVER_ERROR)
                .msg("An unexpected error occurred: " + ex.getMessage());
        return ResponseEntity.internalServerError().body(responseResult);
    }
}
