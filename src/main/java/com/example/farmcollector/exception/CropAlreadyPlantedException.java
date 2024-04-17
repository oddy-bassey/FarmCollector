package com.example.farmcollector.exception;

public class CropAlreadyPlantedException extends RuntimeException {

    public CropAlreadyPlantedException(String message) {
        super(message);
    }
}
