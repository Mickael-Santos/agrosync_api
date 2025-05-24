package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.phenologicalstage.models.PhenologicalStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhenologicalStageRepository extends JpaRepository<PhenologicalStage, Long> {
}
