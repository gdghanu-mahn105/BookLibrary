package com.example.BookLibrary.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<String> HandlingNotFoundResource(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> HandlingArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseEntity<>(methodArgumentNotValidException.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }
}
