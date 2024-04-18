package com.example.farmcollector;

import com.example.farmcollector.service.ReportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Collections;
import java.util.Map;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReportControllerTest.class)
@AutoConfigureMockMvc
class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    @DisplayName("Generate Report API Request Successful")
    void generateReport_ReturnsOk() throws Exception {
        // Arrange
        Map<String, Map<String, Map<String, Double>>> reportData = Collections.emptyMap();
        when(reportService.generateReport()).thenReturn(reportData);

        // Act & Assert
        mockMvc.perform(get("/api/reports/generate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}