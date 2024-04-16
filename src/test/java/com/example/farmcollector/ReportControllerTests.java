package com.example.farmcollector;

import com.example.farmcollector.controller.ReportController;
import com.example.farmcollector.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportControllerTests {

    @Mock
    private ReportService reportService;

    @InjectMocks
    private ReportController reportController;

    @Test
    void testGetFarmReport() {
        // Mock data
        Long farmId = 1L;
        Map<String, Double> expectedReport = new HashMap<>();
        expectedReport.put("Corn", 100.0);
        expectedReport.put("Potato", 80.0);

        // Mock service method
        when(reportService.getExpectedVsActualProductForFarm(farmId)).thenReturn(expectedReport);

        // Test controller method
        ResponseEntity<Map<String, Double>> response = reportController.getFarmReport(farmId);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedReport, response.getBody());
    }

    @Test
    void testGetCropReport() {
        // Mock data
        String cropType = "Corn";
        Map<String, Double> expectedReport = Collections.singletonMap("Corn", 100.0);

        // Mock service method
        when(reportService.getExpectedVsActualProductForCropType(cropType)).thenReturn(expectedReport);

        // Test controller method
        ResponseEntity<Map<String, Double>> response = reportController.getCropReport(cropType);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedReport, response.getBody());
    }
}
