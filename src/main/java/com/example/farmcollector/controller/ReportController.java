package com.example.farmcollector.controller;

import com.example.farmcollector.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/generate")
    public ResponseEntity<Map<String, Map<String, Map<String, Double>>>> generateReport() {
        Map<String, Map<String, Map<String, Double>>> report = reportService.generateReport();
        return ResponseEntity.ok(report);
    }
}