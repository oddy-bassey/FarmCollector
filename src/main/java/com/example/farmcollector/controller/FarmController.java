package com.example.farmcollector.controller;

import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.service.FieldService;
import com.example.farmcollector.service.HarvestService;
import com.example.farmcollector.service.PlantingService;
import com.example.farmcollector.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/farms")
public class FarmController {

    @Autowired
    private PlantingService plantingService;

    @Autowired
    private HarvestService harvestService;

    // Endpoint to receive planting data
    @PostMapping("/{farmId}/plantings")
    public ResponseEntity<String> addPlantingData(@PathVariable Long farmId, @RequestBody PlantingRequest plantingRequest) {
        plantingService.addPlantingData(farmId, plantingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Planting data added successfully.");
    }

    // Endpoint to receive harvesting data
    @PostMapping("/{farmId}/harvests")
    public ResponseEntity<String> addHarvestData(@PathVariable Long farmId, @RequestBody HarvestRequest harvestRequest) {
        harvestService.addHarvestData(farmId, harvestRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Harvest data added successfully.");
    }
}