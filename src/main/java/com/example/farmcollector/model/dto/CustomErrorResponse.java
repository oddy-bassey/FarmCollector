package com.example.farmcollector.model.dto;

import java.time.LocalDateTime;

public record CustomErrorResponse (
        LocalDateTime exceptionTime,
        Integer httpStatus,
        String message,
        String description
){}
