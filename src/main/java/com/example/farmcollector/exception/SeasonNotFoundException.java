package com.example.farmcollector.exception;

public class SeasonNotFoundException extends RuntimeException {

    public SeasonNotFoundException(String message) {
        super(message);
    }
}
