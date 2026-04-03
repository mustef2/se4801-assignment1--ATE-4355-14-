//ATE/4355/14
package com.shopwave.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ✅ Handle "not found" errors
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleRuntimeException(RuntimeException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return error;
    }

    // ✅ Handle bad request (validation, etc.)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleException(Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Something went wrong");

        return error;
    }
}