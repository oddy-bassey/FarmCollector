package com.example.farmcollector.service;

import com.example.farmcollector.model.dao.Field;
import com.example.farmcollector.model.dto.FieldRecord;

public interface FieldService {

    Field createField(FieldRecord fieldRecord);

    Field getField(Long fieldId);

    Field updateField(Long fieldId, FieldRecord fieldRecord);

    void deleteField(Long fieldId);
}
