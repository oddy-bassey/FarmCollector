package com.example.farmcollector.service;

import com.example.farmcollector.model.dto.HarvestingRequest;

public interface HarvestingService {
    void submitHarvestingData(HarvestingRequest request);
}
