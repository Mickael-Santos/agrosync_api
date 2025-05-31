package com.mickaelsantos.apiagrosync.modules.planting.repositories;

import com.mickaelsantos.apiagrosync.modules.planting.models.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingRepository extends JpaRepository<Planting, Long> {
}
