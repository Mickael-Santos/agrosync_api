package com.mickaelsantos.apiagrosync.modules.plantingstage.repositories;

import com.mickaelsantos.apiagrosync.modules.plantingstage.models.PlantingStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingStageRepository extends JpaRepository<PlantingStage, Long> {
}
