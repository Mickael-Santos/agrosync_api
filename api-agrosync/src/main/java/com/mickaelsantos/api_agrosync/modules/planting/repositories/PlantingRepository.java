package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.planting.models.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingRepository extends JpaRepository<Planting, Long> {
}
