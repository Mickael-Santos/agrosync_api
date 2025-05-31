package com.mickaelsantos.apiagrosync.modules.seed.models;

import com.mickaelsantos.apiagrosync.modules.varierity.models.Varierity;
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
@Entity(name = "seeds")
public class Seed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "varierity_id", insertable = false, updatable = false)
    private Varierity varierity;
    @Column(name = "varierity_id")
    private Long varierity_id;
    @ManyToOne()
    @JoinColumn(name = "farm_id", insertable = false, updatable = false)
    private Farm farm;
    @Column(name = "farm_id")
    private Long farm_id;
}
