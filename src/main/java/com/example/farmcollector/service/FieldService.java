package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dao.Season;
import com.example.farmcollector.model.dto.FieldRecord;
import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;

public interface FieldService {

    Field createField(FieldRecord fieldRecord);

    Field getField(Long fieldId);

    Field updateField(Long fieldId, FieldRecord fieldRecord);

    void deleteField(Long fieldId);
    void addPlantingInfo(PlantingRequest request);

    void addHarvestingInfo(HarvestingRequest request);
}
