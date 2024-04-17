package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.CropType;
import com.example.farmcollector.model.dao.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropTypeRepository extends JpaRepository<CropType, Long> {
}
