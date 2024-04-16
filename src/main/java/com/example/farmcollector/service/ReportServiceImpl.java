package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final FieldRepository fieldRepository;
    @Override
    public Map<String, Double> getExpectedVsActualProductForFarm(Long farmId) {
        List<Field> fields = fieldRepository.findBySeasonFarmId(farmId);

        return fields.stream()
                .collect(Collectors.groupingBy(Field::getCropType,
                        Collectors.summingDouble(Field::getExpectedProduct)));
    }

    @Override
    public Map<String, Double> getExpectedVsActualProductForCropType(String cropType) {
        List<Field> fields = fieldRepository.findByCropType(cropType);

        return fields.stream()
                .collect(Collectors.groupingBy(Field::getCropType,
                        Collectors.summingDouble(Field::getExpectedProduct)));
    }
}
