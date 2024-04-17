package com.example.farmcollector.exception;

public class FarmNotFoundException extends RuntimeException {

    public FarmNotFoundException(String message) {
        super(message);
    }
}
