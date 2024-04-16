package com.example.farmcollector.controller;

import com.example.farmcollector.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<Map<String, Double>> getFarmReport(@PathVariable Long farmId) {
        Map<String, Double> report = reportService.getExpectedVsActualProductForFarm(farmId);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/crop/{cropType}")
    public ResponseEntity<Map<String, Double>> getCropReport(@PathVariable String cropType) {
        Map<String, Double> report = reportService.getExpectedVsActualProductForCropType(cropType);
        return ResponseEntity.ok(report);
    }
}