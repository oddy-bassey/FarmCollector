package com.example.farmcollector.model.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cropType;
    private double plantingArea;
    private double expectedProduct;
    private double actualProduct;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
}
