package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingRepository extends JpaRepository<Planting, Long> {
    boolean existsByFieldIdAndCropTypeIdAndSeasonId(Long fieldId, Long cropTypeId, Long seasonId);
}
