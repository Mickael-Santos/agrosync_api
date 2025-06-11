package com.mickaelsantos.apiagrosync.modules.planting.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.mickaelsantos.apiagrosync.modules.phenology.models.PhenologicalStage;

import lombok.Data;

@Data
@Entity(name = "maturation_groups")
public class MaturationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private short estimatedDays;
    @OneToMany(mappedBy = "maturation_group_id")
    private List<PhenologicalStage> phenologicalStages;
}
