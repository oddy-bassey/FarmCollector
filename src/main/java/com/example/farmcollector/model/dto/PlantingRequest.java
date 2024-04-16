package com.example.farmcollector.model.dto;

public record PlantingRequest (
        Long fieldId,
        Double plantingArea,
        String cropType,
        Double expectedProduct) {}
