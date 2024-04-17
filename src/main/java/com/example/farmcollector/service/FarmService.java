package com.example.farmcollector.service;

import com.example.farmcollector.model.dto.HarvestRequest;
import com.example.farmcollector.model.dto.PlantingRequest;

public interface FarmService {

    void addPlantingData(Long farmId, PlantingRequest plantingRequest);
    void addHarvestData(Long farmId, HarvestRequest harvestRequest);
}
