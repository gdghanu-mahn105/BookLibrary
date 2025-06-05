package com.example.BookLibrary.core.exception;

public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
}
