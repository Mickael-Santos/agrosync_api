package com.mickaelsantos.apiagrosync.modules.farm.models;

import com.mickaelsantos.apiagrosync.modules.user.models.User;
import com.mickaelsantos.apiagrosync.modules.field.models.Field;
import com.mickaelsantos.apiagrosync.modules.harvest.models.Harvest;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; 
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String identification;
    private String stateRegistration;
    private boolean active;
    @OneToMany(mappedBy = "farm_id")
    private List<User> users;
    @OneToMany(mappedBy = "farm_id")
    private List<Harvest> harvests;
    @OneToMany(mappedBy = "farm_id")
    private List<Field> fields;
}
