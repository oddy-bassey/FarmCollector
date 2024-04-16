package com.example.farmcollector.model.dto;

public record HarvestingRequest (
        Long farmId,
        Long seasonId,
        Double actualProduct
) {}
