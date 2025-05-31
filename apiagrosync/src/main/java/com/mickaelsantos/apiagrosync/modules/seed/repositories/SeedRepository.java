package com.mickaelsantos.apiagrosync.modules.seed.repositories;

import com.mickaelsantos.apiagrosync.modules.seed.models.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
