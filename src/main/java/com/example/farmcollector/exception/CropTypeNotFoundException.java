package com.example.farmcollector.exception;

public class CropTypeNotFoundException extends RuntimeException {

    public CropTypeNotFoundException(String message) {
        super(message);
    }
}
