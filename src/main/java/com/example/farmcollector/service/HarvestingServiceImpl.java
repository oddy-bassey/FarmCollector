package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HarvestingServiceImpl implements HarvestingService {

    private final FieldRepository fieldRepository;
    @Override
    public void submitHarvestingData(HarvestingRequest request) {

    }
}
