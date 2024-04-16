package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlantingServiceImpl implements PlantingService {

    private final FieldRepository fieldRepository;
    @Override
    public void submitPlantingData(PlantingRequest request) {

    }
}
