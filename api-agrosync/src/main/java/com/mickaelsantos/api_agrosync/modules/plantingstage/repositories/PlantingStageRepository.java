package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.plantingstage.models.PlantingStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingStageRepository extends JpaRepository<PlantingStage, Long> {
}
