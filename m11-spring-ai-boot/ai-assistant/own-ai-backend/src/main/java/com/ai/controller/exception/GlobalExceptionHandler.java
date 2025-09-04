package com.ai.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidCharacterException.class)
    public ResponseEntity<Map<String,Object>> handleException(InvalidCharacterException e) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", e.getMessage());
        errors.put("result", "Invalid Characters");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }
}
