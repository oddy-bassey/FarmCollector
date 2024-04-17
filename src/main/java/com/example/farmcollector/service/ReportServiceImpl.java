package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dao.Harvest;
import com.example.farmcollector.model.dao.Planting;
import com.example.farmcollector.repository.FieldRepository;
import com.example.farmcollector.repository.HarvestRepository;
import com.example.farmcollector.repository.PlantingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private PlantingRepository plantingRepository;

    private HarvestRepository harvestRepository;

    public Map<String, Map<String, Map<String, Double>>> generateReport() {
        // Retrieve all plantings
        List<Planting> plantings = plantingRepository.findAll();

        // Retrieve all harvests
        List<Harvest> harvests = harvestRepository.findAll();

        // Calculate expected and actual amounts of product for each farm, crop type, and season
        Map<String, Map<String, Map<String, Double>>> report = plantings.stream()
                .collect(Collectors.groupingBy(
                        planting -> planting.getField().getFarm().getName(),
                        Collectors.groupingBy(
                                planting -> planting.getCropType().getName(),
                                Collectors.groupingBy(
                                        planting -> planting.getSeason().getName(),
                                        Collectors.summingDouble(Planting::getExpectedProductAmount)
                                )
                        )
                ));

        for (Harvest harvest : harvests) {
            String farmName = harvest.getPlanting().getField().getFarm().getName();
            String cropTypeName = harvest.getPlanting().getCropType().getName();
            String seasonName = harvest.getPlanting().getSeason().getName();
            double actualHarvestedAmount = harvest.getActualHarvestedAmount();
            report.get(farmName)
                    .get(cropTypeName)
                    .merge(seasonName, actualHarvestedAmount, Double::sum);
        }

        return report;
    }
}
