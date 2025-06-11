package com.mickaelsantos.apiagrosync.modules.phenology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.phenology.models.PhenologicalStage;

public interface PhenologicalStageRepository extends JpaRepository<PhenologicalStage, Long> {
}
