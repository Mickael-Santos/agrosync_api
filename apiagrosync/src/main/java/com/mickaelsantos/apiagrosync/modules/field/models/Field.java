package com.mickaelsantos.apiagrosync.modules.field.models;

import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    @ManyToOne()
    @JoinColumn(name = "farm_id", insertable = false, updatable = false)
    private Farm farm;
    @Column(name = "farm_id")
    private Long farm_id;
}