package com.example.farmcollector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
class FarmIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setupDatabase(@Autowired JdbcTemplate jdbcTemplate) throws IOException {
        String schemaFilePath = new ClassPathResource("schema.sql").getFile().getAbsolutePath();
        StringBuilder scriptContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(schemaFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptContent.append(line).append("\n");
            }
        }
        jdbcTemplate.execute(scriptContent.toString());
    }

    @Test
    @DisplayName("Test Add Planting Data")
    void testAddPlantingData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/farms/1/plantings")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"fieldId\": 1, \"seasonId\": 1, \"cropTypeId\": 1, \"expectedProductAmount\": 100.0 }"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Test Add Harvest Data")
    void testAddHarvestData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/farms/1/harvests")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"plantingId\": 1, \"actualHarvestedAmount\": 80.0 }"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Test Generate Report Data")
    void testGenerateReport() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reports/generate"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
