package com.example.farmcollector.model.dto;

public record PlantingRequest (
        Long farmId,
        Long seasonId,
        String cropType,
        Double plantingArea,
        Double expectedProduct) {}
