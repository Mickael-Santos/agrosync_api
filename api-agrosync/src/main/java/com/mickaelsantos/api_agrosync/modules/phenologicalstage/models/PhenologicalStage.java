package com.mickaelsantos.api_agrosync.modules.phenologicalstage.models;

import com.mickaelsantos.api_agrosync.modules.maturationgroup.models.MaturationGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity(name = "phenological_stages")
public class PhenologicalStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private short order;
    private Long degreeDay;
    private int cyclePercent;
    @ManyToOne()
    @JoinColumn(name = "maturation_group_id", insertable = false, updatable = false)
    private MaturationGroup maturationGroup;
    @Column(name = "maturation_group_id")
    private Long maturation_group_id;
}
