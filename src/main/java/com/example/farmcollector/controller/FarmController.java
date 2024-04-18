package com.example.farmcollector.controller;

import com.example.farmcollector.model.dto.*;
import com.example.farmcollector.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/farms")
public class FarmController {

    private final FarmService farmService;

    // Endpoint to receive planting data
    @PostMapping("/{farmId}/plantings")
    public ResponseEntity<String> addPlantingData(@PathVariable Long farmId, @RequestBody PlantingRequest plantingRequest) {
        farmService.addPlantingData(farmId, plantingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Planting data added successfully.");
    }

    // Endpoint to receive harvesting data
    @PostMapping("/{farmId}/harvests")
    public ResponseEntity<String> addHarvestData(@PathVariable Long farmId, @RequestBody HarvestRequest harvestRequest) {
        farmService.addHarvestData(farmId, harvestRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Harvest data added successfully.");
    }
}