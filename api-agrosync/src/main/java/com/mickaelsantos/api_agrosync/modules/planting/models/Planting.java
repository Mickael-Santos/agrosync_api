package com.mickaelsantos.api_agrosync.modules.planting.models;

import com.mickaelsantos.api_agrosync.modules.field.models.Field;
import com.mickaelsantos.api_agrosync.modules.seed.models.Seed;
import com.mickaelsantos.api_agrosync.modules.harvest.models.Harvest;
import com.mickaelsantos.api_agrosync.modules.plantingstage.models.PlantingStage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity(name = "plantings")
public class Planting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "field_id", insertable = false, updatable = false)
    private Field field;
    @Column(name = "field_id")
    private Long field_id;
    @ManyToOne
    @JoinColumn(name = "farm_id", insertable = false, updatable = false)
    private Seed seed;
    @Column(name = "seed_id")
    private Long seed_id;
    @ManyToOne
    @JoinColumn(name = "harvest_id", insertable = false, updatable = false)
    private Harvest harvest;
    @Column(name = "harvest_id")
    private Long harvest_id;
    private LocalDateTime initialDay;
    private LocalDateTime finalDay;
    @ManyToOne
    @JoinColumn(name = "planting_stage_id", insertable = false, updatable = false)
    private PlantingStage stage;
    @Column(name = "planting_stage_id")
    private Long planting_stage_id;
}

