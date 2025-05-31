package com.mickaelsantos.apiagrosync.modules.phenologicalstage.repositories;

import com.mickaelsantos.apiagrosync.modules.phenologicalstage.models.PhenologicalStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhenologicalStageRepository extends JpaRepository<PhenologicalStage, Long> {
}
