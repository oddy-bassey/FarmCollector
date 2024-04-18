package com.example.farmcollector;

import com.example.farmcollector.controller.FarmController;
import com.example.farmcollector.service.FarmService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FarmController.class)
@AutoConfigureMockMvc
class FarmControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmService farmService;

    @Test
    @DisplayName("Add Planting Data API Request Successful")
    void addPlantingData_ValidRequest_ReturnsCreated() throws Exception {
        // Arrange
        Mockito.doNothing().when(farmService).addPlantingData(any(), any());

        // Act & Assert
        mockMvc.perform(post("/api/v1/farms/1/plantings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"fieldId\": 1, \"seasonId\": 1, \"cropTypeId\": 1, \"expectedProductAmount\": 100.0 }"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Add Harvest Data API Request Successful")
    void addHarvestData_ValidRequest_ReturnsCreated() throws Exception {
        // Arrange
        Mockito.doNothing().when(farmService).addHarvestData(any(), any());

        // Act & Assert
        mockMvc.perform(post("/api/v1/farms/1/harvests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"plantingId\": 1, \"actualHarvestedAmount\": 80.0 }"))
                .andExpect(status().isCreated());
    }
}