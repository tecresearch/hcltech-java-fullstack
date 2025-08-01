package com.hcl.exception.controller;

import com.hcl.exception.ProductIdNotRequired;
import com.hcl.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hcl.exception.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> sentProductNotFoundException(ProductNotFoundException ex, WebRequest request) {

        ErrorResponse errorResponse=new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=","")
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(ProductIdNotRequired.class)
    public ResponseEntity<ErrorResponse> sentProductIdNotRequired(ProductIdNotRequired ex,WebRequest request){
            ErrorResponse errorResponse=new ErrorResponse(
                    HttpStatus.NOT_ACCEPTABLE.value(),
                    HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(),
                    ex.getMessage(),
                    request.getDescription(false).replace("uri=","")
            );
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
    }


}
