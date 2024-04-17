package com.example.farmcollector.service;

import com.example.farmcollector.model.dto.PlantingRequest;

public interface PlantingService {

    void addPlantingData(Long farmId, PlantingRequest plantingRequest);
}
