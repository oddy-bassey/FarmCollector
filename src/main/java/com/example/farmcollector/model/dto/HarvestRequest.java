package com.example.farmcollector.model.dto;

public record HarvestRequest(
        Long plantingId,
        double actualHarvestedAmount
) {}
