package com.example.farmcollector;

import com.example.farmcollector.model.dao.*;
import com.example.farmcollector.model.dto.HarvestRequest;
import com.example.farmcollector.model.dto.PlantingRequest;

import java.util.Arrays;
import java.util.Random;

public class TestData {
    // Helper methods for creating mock objects...

    public static PlantingRequest createPlantingRequest() {
        // Create and return a PlantingRequest object for testing
        return new PlantingRequest(1L, 1L, 1L, 34);
    }

    public static HarvestRequest createHarvestRequest() {
        // Create and return a HarvestRequest object for testing
        return new HarvestRequest(2L, new Random(60).nextInt());
    }

    public static Farm createFarm() {
        // Create and return a Farm object for testing
        return Farm.builder()
                .id(1L)
                .name("Almat")
                .location("Africa")
                .build();
    }

    public static Field createField() {
        // Create and return a Field object for testing
        return Field.builder()
                .id(1L)
                .farm(createFarm())
                .plantingArea(700)
                .build();
    }

    public static CropType createCropType() {
        // Create and return a CropType object for testing
        return CropType.builder()
                .id(1L)
                .name(Arrays.asList("Maize", "Rice", "Corn", "Millet", "Yam", "Peanuts")
                        .get(new Random().nextInt(5)))
                .build();
    }

    public static Season createSeason() {
        // Create and return a Season object for testing
        return Season.builder()
                .id(1L)
                .name(Arrays.asList("Autumn", "Winter", "Summer", "Spring")
                        .get(new Random().nextInt(5)))
                .build();
    }

    public static Planting createPlanting() {
        // Create and return a Planting object for testing
        return Planting.builder()
                .id(1L)
                .expectedProductAmount(70)
                .cropType(createCropType())
                .season(createSeason())
                .field(createField())
                .build();
    }

    public static Harvest createHarvest() {
        // Create and return a Harvest object for testing
        return Harvest.builder()
                .id(1L)
                .actualHarvestedAmount(new Random(60).nextInt())
                .planting(createPlanting())
                .build();
    }
}
