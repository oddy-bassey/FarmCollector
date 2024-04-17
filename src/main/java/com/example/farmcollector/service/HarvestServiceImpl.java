package com.example.farmcollector.service;

import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HarvestServiceImpl implements HarvestService {

    private final FieldRepository fieldRepository;
    @Override
    public void submitHarvestingData(HarvestingRequest request) {

    }
}
