package com.example.farmcollector.repository;

import com.example.farmcollector.model.dao.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
