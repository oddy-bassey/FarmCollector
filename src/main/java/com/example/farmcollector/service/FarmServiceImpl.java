package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dto.FarmRecord;
import com.example.farmcollector.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FarmServiceImpl implements FarmService{

    private final FarmRepository farmRepository;

    @Override
    public Farm createFarm(FarmRecord farmRecord) {
        Farm farm = Farm.builder().name(farmRecord.name()).build();
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarm(Long farmId) {
        return farmRepository.findById(farmId)
                .orElseThrow(() -> new NotFoundException("Farm not found with id: " + farmId));
    }

    @Override
    public Farm updateFarm(Long farmId, FarmRecord farmRecord) {
        Farm farm = getFarm(farmId);
        farm.setName(farmRecord.name());
        return farmRepository.save(farm);
    }

    @Override
    public void deleteFarm(Long farmId) {
        Farm farm = getFarm(farmId);
        farmRepository.delete(farm);
    }
}
