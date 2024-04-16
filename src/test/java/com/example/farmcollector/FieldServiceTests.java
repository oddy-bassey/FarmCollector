package com.example.farmcollector;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.repository.FieldRepository;
import com.example.farmcollector.service.FieldService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class FieldServiceTests {

    @Mock
    private FieldRepository fieldRepository;

    @InjectMocks
    private FieldService fieldService;

    @Test
    void testAddPlantingInfo() {
        // Mock request
        PlantingRequest request = new PlantingRequest(1L,2L,"Corn", 50.0, 100.0);

        // Mock Field object
        Field field = new Field();
        field.setPlantingArea(request.plantingArea());
        field.setCropType(request.cropType());
        field.setExpectedProduct(request.expectedProduct());

        // Mock repository method
        when(fieldRepository.save(field)).thenReturn(field);

        // Call service method
        fieldService.addPlantingInfo(request);

        // Verify that the repository method is called with the correct parameters
        verify(fieldRepository).save(field);
    }

    @Test
    void testAddHarvestingInfo() {
        // Mock request
        HarvestingRequest request = new HarvestingRequest(1L, 1L, 75.0);

        // Mock Field object
        Field field = new Field();
        field.setActualProduct(request.actualProduct());

        // Mock repository method
        when(fieldRepository.save(field)).thenReturn(field);

        // Call service method
        fieldService.addHarvestingInfo(request);

        // Verify that the repository method is called with the correct parameters
        verify(fieldRepository).save(field);
    }
}
