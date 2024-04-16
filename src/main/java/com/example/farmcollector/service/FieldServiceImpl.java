package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dao.Season;
import com.example.farmcollector.model.dto.FieldRecord;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FieldService {

    private FieldRepository fieldRepository;

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

    public Field getField(Long fieldId) {
        return fieldRepository.findById(fieldId)
                .orElseThrow(() -> new NotFoundException("Field not found with id: " + fieldId));
    }

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

    public void deleteField(Long fieldId) {
        Field field = getField(fieldId);
        fieldRepository.delete(field);
    }
}
