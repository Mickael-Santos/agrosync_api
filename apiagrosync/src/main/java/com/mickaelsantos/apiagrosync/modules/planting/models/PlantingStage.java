package com.mickaelsantos.apiagrosync.modules.planting.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.mickaelsantos.apiagrosync.modules.phenology.models.PhenologicalStage;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "planting_stages")
public class PlantingStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "planting_id", insertable = false, updatable = false)
    private Planting planting;
    @Column(name = "planting_id")
    private Long planting_id;
    @ManyToOne()
    @JoinColumn(name = "phenological_stage_id", insertable = false, updatable = false)
    private PhenologicalStage phenologicalStage;
    @Column(name = "phenological_stage_id")
    private Long phenologicalStage_id;
    private Long acomulatedDegreeDay;
    private int days;
}
