package com.example.farmcollector.service;

import com.example.farmcollector.model.dto.HarvestingRequest;

public interface HarvestService {
    void submitHarvestingData(HarvestingRequest request);
}
