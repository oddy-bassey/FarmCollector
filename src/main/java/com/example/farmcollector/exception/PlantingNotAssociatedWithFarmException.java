package com.example.farmcollector.exception;

public class PlantingNotAssociatedWithFarmException extends RuntimeException {

    public PlantingNotAssociatedWithFarmException(String message) {
        super(message);
    }
}
