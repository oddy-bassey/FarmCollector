package com.example.farmcollector.exception.handler;

import com.example.farmcollector.exception.*;
import com.example.farmcollector.model.dto.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({
            FarmNotFoundException.class,
            FieldNotFoundException.class,
            CropTypeNotFoundException.class,
            SeasonNotFoundException.class,
            FieldNotAssociatedWithFarmException.class,
            CropAlreadyPlantedException.class,
            PlantingNotFoundException.class,
            PlantingNotAssociatedWithFarmException.class //, HarvestAmountExceedsPlantedAmountException.class
    })
    public ResponseEntity<CustomErrorResponse> handleCustomExceptions(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleOtherExceptions(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
