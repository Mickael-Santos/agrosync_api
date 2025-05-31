package com.mickaelsantos.apiagrosync.modules.harvest.repositories;

import com.mickaelsantos.apiagrosync.modules.harvest.models.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
