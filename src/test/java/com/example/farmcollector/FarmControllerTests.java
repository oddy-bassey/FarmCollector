import com.example.farmcollector.model.dto.HarvestingRequest;
import com.example.farmcollector.model.dto.PlantingRequest;
import com.example.farmcollector.service.FieldService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FieldService fieldService;

    @Test
    public void testAddPlantingInfo() throws Exception {
        // Mock request
        PlantingRequest request = new PlantingRequest();
        request.setPlantingArea(10); // Mock planting area
        request.setCropType("Corn"); // Mock crop type
        request.setExpectedProduct(5); // Mock expected product

        // Mocked farm ID
        Long farmId = 1L;

        // Mock service method when called with specific parameters
        when(fieldService.addPlantingInfo(farmId, request)).thenReturn(/* Mock return value */);

        // Perform POST request to the controller endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/farm/{farmId}/planting", farmId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());

        // Verify that the corresponding service method is called with the correct parameters
        verify(fieldService).addPlantingInfo(farmId, request);
    }

    @Test
    public void testAddHarvestingInfo() throws Exception {
        // Mock request
        HarvestingRequest request = new HarvestingRequest();
        request.setActualProduct(8); // Mock actual product

        // Mocked farm ID
        Long farmId = 1L;

        // Mock service method when called with specific parameters
        when(fieldService.addHarvestingInfo(farmId, request)).thenReturn(/* Mock return value */);

        // Perform POST request to the controller endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/farm/{farmId}/harvesting", farmId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());

        // Verify that the corresponding service method is called with the correct parameters
        verify(fieldService).addHarvestingInfo(farmId, request);
    }
}