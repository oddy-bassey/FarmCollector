package com.example.farmcollector.controller;

import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.service.FieldService;
import com.example.farmcollector.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FieldService fieldService;

    private final SeasonService seasonService;

    // API to add planting information
    @PostMapping("/plant")
    public ResponseEntity<String> addPlantingInfo(@RequestBody PlantingRequest request) {
        try {
            fieldService.addPlantingInfo(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Planting information added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add planting information");
        }
    }

    // API to add harvesting information
    @PostMapping("/harvest")
    public ResponseEntity<String> addHarvestingInfo(@RequestBody HarvestingRequest request) {
        try {
            fieldService.addHarvestingInfo(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Harvesting information added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add harvesting information");
        }
    }
}