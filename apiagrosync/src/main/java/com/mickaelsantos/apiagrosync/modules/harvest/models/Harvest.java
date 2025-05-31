package com.mickaelsantos.apiagrosync.modules.harvest.models;

import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String acronym;
    @ManyToOne()
    @JoinColumn(name = "farm_id", insertable = false, updatable = false)
    private Farm farm;
    @Column(name = "farm_id")
    private Long farm_id;
}