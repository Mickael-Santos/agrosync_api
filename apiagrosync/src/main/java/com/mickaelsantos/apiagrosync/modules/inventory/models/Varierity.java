package com.mickaelsantos.apiagrosync.modules.inventory.models;

import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;
import com.mickaelsantos.apiagrosync.modules.planting.models.MaturationGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity(name = "varierities")
public class Varierity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "maturation_group_id", insertable = false, updatable = false)
    private MaturationGroup maturationGroup;
    @Column(name = "maturation_group_id")
    private Long maturation_group_id;
    @ManyToOne()
    @JoinColumn(name = "farm_id", insertable = false, updatable = false)
    private Farm farm;
    @Column(name = "farm_id")
    private Long farm_id;
    private boolean systemDefault;
}
