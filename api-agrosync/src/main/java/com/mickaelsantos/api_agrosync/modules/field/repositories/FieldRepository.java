package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.field.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
