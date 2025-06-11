package com.mickaelsantos.apiagrosync.modules.farm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.farm.models.Field;

public interface FieldRepository extends JpaRepository<Field, Long> {

    Optional<Field> findByNameAndFarmId(String name, Long farmId);
}
