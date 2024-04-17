package com.example.farmcollector.model.dto;

public record PlantingRequest(
        Long fieldId,
        Long seasonId,
        Long cropTypeId,
        double expectedProductAmount
) {}
