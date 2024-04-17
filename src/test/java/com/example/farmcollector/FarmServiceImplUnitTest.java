package com.example.farmcollector;

import com.example.farmcollector.exception.CropTypeNotFoundException;
import com.example.farmcollector.exception.FarmNotFoundException;
import com.example.farmcollector.exception.FieldNotAssociatedWithFarmException;
import com.example.farmcollector.exception.FieldNotFoundException;
import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dao.Planting;
import com.example.farmcollector.repository.*;
import com.example.farmcollector.service.FarmServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FarmServiceImplUnitTest {

    @Mock
    private FarmRepository farmRepository;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private CropTypeRepository cropTypeRepository;

    @Mock
    private PlantingRepository plantingRepository;

    @Mock
    private SeasonRepository seasonRepository;

    @Mock
    private HarvestRepository harvestRepository;

    @InjectMocks
    private FarmServiceImpl farmService;


    @Test
    @DisplayName("Add Planting Data Throws FarmNotFoundException")
    void addPlantingData_WhenFarmNotFound_ThrowsFarmNotFoundException() {
        // Arrange
        when(farmRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(FarmNotFoundException.class, () -> farmService.addPlantingData(1L, TestData.createPlantingRequest()));
    }

    @Test
    @DisplayName("Add Planting Data Throws FieldNotFoundException")
    void addPlantingData_WhenFieldNotFound_ThrowsFieldNotFoundException() {
        // Arrange
        when(farmRepository.findById(any())).thenReturn(Optional.of(TestData.createFarm()));
        when(fieldRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(FieldNotFoundException.class, () -> farmService.addPlantingData(1L, TestData.createPlantingRequest()));
    }

    @Test
    @DisplayName("Add Planting Data Throws FieldNotAssociatedWithFarmException")
    void addPlantingData_WhenFieldNotAssociatedWithFarm_ThrowsFieldNotAssociatedWithFarmException() {
        Long farmId = 2L;
        when(farmRepository.findById(any())).thenReturn(Optional.of(Farm.builder()
                .id(farmId)
                .name("Pact")
                .location("Africa")
                .build()));
        when(fieldRepository.findById(any())).thenReturn(Optional.of(TestData.createField()));

        // Act & Assert
        assertThrows(FieldNotAssociatedWithFarmException.class, () -> farmService.addPlantingData(farmId, TestData.createPlantingRequest()));
    }

    @Test
    @DisplayName("Add Planting Data Throws CropTypeNotFoundException")
    void addPlantingData_WhenCropTypeNotFound_ThrowsCropTypeNotFoundException() {
        // Arrange
        when(farmRepository.findById(any())).thenReturn(Optional.of(TestData.createFarm()));
        when(fieldRepository.findById(any())).thenReturn(Optional.of(TestData.createField()));
        when(cropTypeRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CropTypeNotFoundException.class, () -> farmService.addPlantingData(1L, TestData.createPlantingRequest()));
    }

    @Test
    @DisplayName("Add Planting Data Successfully")
    void addPlantingData_WhenAllChecksPass_PlantingAddedSuccessfully() {
        // Arrange
        when(farmRepository.findById(any())).thenReturn(Optional.of(TestData.createFarm()));
        when(fieldRepository.findById(any())).thenReturn(Optional.of(TestData.createField()));
        when(cropTypeRepository.findById(any())).thenReturn(Optional.of(TestData.createCropType()));
        when(seasonRepository.findById(any())).thenReturn(Optional.of(TestData.createSeason()));
        when(plantingRepository.existsByFieldIdAndCropTypeIdAndSeasonId(any(), any(), any())).thenReturn(false);

        // Act
        farmService.addPlantingData(1L, TestData.createPlantingRequest());

        // Assert
        verify(plantingRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Add Harvest Data Successfully")
    void addHarvestData_WhenAllChecksPass_HarvestAddedSuccessfully() {
        // Arrange
        Planting planting = TestData.createPlanting();
        when(plantingRepository.findById(any())).thenReturn(Optional.of(planting));
        when(harvestRepository.save(any())).thenReturn(TestData.createHarvest());

        // Act
        farmService.addHarvestData(1L, TestData.createHarvestRequest());

        // Assert
        verify(harvestRepository, times(1)).save(any());
    }
}