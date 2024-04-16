package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dao.Season;
import com.example.farmcollector.model.dto.FieldRecord;
import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FieldServiceImpl implements FieldService{

    private FieldRepository fieldRepository;

    @Override
    public Field createField(FieldRecord fieldRecord) {
        Season season = Season.builder()
                .id(fieldRecord.seasonId())
                .build();

        Field field = Field.builder()
                .cropType(fieldRecord.cropType())
                .plantingArea(fieldRecord.plantingArea())
                .expectedProduct(fieldRecord.expectedProduct())
                .season(season)
                .build();

        return fieldRepository.save(field);
    }

    @Override
    public Field getField(Long fieldId) {
        return fieldRepository.findById(fieldId)
                .orElseThrow(() -> new NotFoundException("Field not found with id: " + fieldId));
    }

    @Override
    public Field updateField(Long fieldId, FieldRecord fieldRecord) {
        Field field = getField(fieldId);
        field.setCropType(fieldRecord.cropType());
        field.setPlantingArea(fieldRecord.plantingArea());
        field.setExpectedProduct(fieldRecord.expectedProduct());

        Season season = new Season();
        season.setId(fieldRecord.seasonId());
        field.setSeason(season);
        return fieldRepository.save(field);
    }

    @Override
    public void deleteField(Long fieldId) {
        Field field = getField(fieldId);
        fieldRepository.delete(field);
    }

    @Override
    public void addPlantingInfo(PlantingRequest request) {
        Field field = new Field();
        field.setCropType(request.cropType());
        field.setPlantingArea(request.plantingArea());
        field.setExpectedProduct(request.expectedProduct());

        Season season = new Season();
        season.setId(request.seasonId());

        field.setSeason(season);

        // Assuming farmId is not needed for planting info
        // If needed, you can set it here as well

        fieldRepository.save(field);
    }

    @Override
    public void addHarvestingInfo(HarvestingRequest request) {
        // Assuming farmId is not needed for harvesting info
        // If needed, you can set it here as well

        // Fetch field using farmId and seasonId
        Field field = fieldRepository.findBySeasonId(request.seasonId());

        if (field != null) {
            field.setActualProduct(request.actualProduct());
            fieldRepository.save(field);
        } else {
            // Handle the case where the field doesn't exist for the given season
            // You can throw an exception or log an error message
        }
    }
}
