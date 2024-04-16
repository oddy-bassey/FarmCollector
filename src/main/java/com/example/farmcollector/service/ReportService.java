package com.example.farmcollector.service;

import java.util.Map;

public interface ReportService {

    Map<String, Double> getExpectedVsActualProductForFarm(Long farmId);

    Map<String, Double> getExpectedVsActualProductForCropType(String cropType);
}
