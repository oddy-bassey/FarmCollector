package com.example.farmcollector.service;

import com.example.farmcollector.exception.NotFoundException;
import com.example.farmcollector.model.dao.Farm;
import com.example.farmcollector.model.dto.FarmRecord;

public interface FarmService {

    Farm createFarm(FarmRecord farmRecord);

    Farm getFarm(Long farmId);

    Farm updateFarm(Long farmId, FarmRecord farmRecord);

    void deleteFarm(Long farmId);
}
