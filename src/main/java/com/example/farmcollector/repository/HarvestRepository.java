package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
