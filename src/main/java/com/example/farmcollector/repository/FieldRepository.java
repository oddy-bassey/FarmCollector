package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {

    Field findBySeasonId(Long season_id);

    List<Field> findByFarmId(Long farmId);

    List<Field> findByCropType(String cropType);
}
