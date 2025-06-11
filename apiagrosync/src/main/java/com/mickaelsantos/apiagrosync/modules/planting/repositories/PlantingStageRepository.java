package com.mickaelsantos.apiagrosync.modules.planting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.planting.models.PlantingStage;

public interface PlantingStageRepository extends JpaRepository<PlantingStage, Long> {
}
