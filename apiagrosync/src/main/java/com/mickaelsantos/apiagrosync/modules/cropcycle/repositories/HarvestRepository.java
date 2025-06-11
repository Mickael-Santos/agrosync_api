package com.mickaelsantos.apiagrosync.modules.cropcycle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.cropcycle.models.Harvest;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
