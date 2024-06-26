package com.example.farmcollector.service;

import com.example.farmcollector.exception.*;
import com.example.farmcollector.model.dao.*;
import com.example.farmcollector.model.dto.HarvestRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FieldRepository fieldRepository;
    private final CropTypeRepository cropTypeRepository;
    private final PlantingRepository plantingRepository;
    private final SeasonRepository seasonRepository;
    private final HarvestRepository harvestRepository;

    @Override
    public void addPlantingData(Long farmId, PlantingRequest plantingRequest) {
        // Check if farm exists
        Optional<Farm> farmOptional = farmRepository.findById(farmId);
        if (farmOptional.isEmpty()) {
            throw new FarmNotFoundException("Farm with id " + farmId + " not found.");
        }

        // Check if field exists and is associated with the farm
        Long fieldId = plantingRequest.fieldId();
        Field field = fieldRepository.findById(fieldId)
                .orElseThrow(() -> new FieldNotFoundException("Field with id " + fieldId + " not found."));
        if (!field.getFarm().getId().equals(farmId)) {
            throw new FieldNotAssociatedWithFarmException("Field with id " + fieldId + " is not associated with farm " + farmId);
        }

        // Check if the crop exists
        Long cropTypeId = plantingRequest.cropTypeId();
        CropType cropType = cropTypeRepository.findById(cropTypeId)
                .orElseThrow(() -> new CropTypeNotFoundException("Crop with id " + cropTypeId + " not found."));

        // Check if the season exists
        Long seasonId = plantingRequest.seasonId();
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new SeasonNotFoundException("Season with id " + seasonId + " not found."));


        // Check if the crop is already planted on the field in the same season
        boolean isAlreadyPlanted = plantingRepository.existsByFieldIdAndCropTypeIdAndSeasonId(fieldId, cropTypeId, seasonId);
        if (isAlreadyPlanted) {
            throw new CropAlreadyPlantedException("Crop with id " + cropTypeId + " is already planted on field with id " + fieldId + " in season with id " + seasonId);
        }

        // All checks passed, proceed with planting
        Planting planting = Planting.builder()
                .field(field)
                .season(season)
                .cropType(cropType)
                .expectedProductAmount(plantingRequest.expectedProductAmount())
                .build();
        plantingRepository.save(planting);
    }

    @Override
    public void addHarvestData(Long farmId, HarvestRequest harvestRequest) {
        // Check if planting exists
        Long plantingId = harvestRequest.plantingId();
        Planting planting = plantingRepository.findById(plantingId)
                .orElseThrow(() -> new PlantingNotFoundException("Planting with id " + plantingId + " not found."));

        // Check if the planting is associated with the specified farm
        if (!planting.getField().getFarm().getId().equals(farmId)) {
            throw new PlantingNotAssociatedWithFarmException("Planting with id " + plantingId + " is not associated with farm " + farmId);
        }

        // All checks passed, proceed with adding harvest data
        Harvest harvest = Harvest.builder()
                .planting(planting)
                .actualHarvestedAmount(harvestRequest.actualHarvestedAmount())
                .build();
        harvestRepository.save(harvest);
    }
}
