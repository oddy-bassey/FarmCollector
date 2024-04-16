package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dao.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
