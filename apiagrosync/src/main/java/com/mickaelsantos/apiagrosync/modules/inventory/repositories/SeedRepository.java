package com.mickaelsantos.apiagrosync.modules.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.inventory.models.Seed;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
