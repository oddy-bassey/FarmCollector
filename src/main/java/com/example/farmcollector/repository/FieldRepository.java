package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
