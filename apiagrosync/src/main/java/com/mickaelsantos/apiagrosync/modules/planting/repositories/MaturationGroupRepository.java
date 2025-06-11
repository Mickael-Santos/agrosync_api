package com.mickaelsantos.apiagrosync.modules.planting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.planting.models.MaturationGroup;

public interface MaturationGroupRepository extends JpaRepository<MaturationGroup, Long> {
}
