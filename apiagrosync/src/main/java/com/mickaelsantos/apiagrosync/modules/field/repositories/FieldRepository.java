package com.mickaelsantos.apiagrosync.modules.field.repositories;

import com.mickaelsantos.apiagrosync.modules.field.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
