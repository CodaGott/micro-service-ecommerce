package com.dozie.ecommerce.handler;

import com.dozie.ecommerce.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.status(NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String,String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldError = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldError, errorMessage);
        });
        return ResponseEntity.status(BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }

}
