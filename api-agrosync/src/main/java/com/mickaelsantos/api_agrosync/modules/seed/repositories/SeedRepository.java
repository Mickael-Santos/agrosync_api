package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.seed.models.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
