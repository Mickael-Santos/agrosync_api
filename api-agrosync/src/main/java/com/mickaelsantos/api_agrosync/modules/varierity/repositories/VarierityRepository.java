package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.varierity.models.Varierity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarierityRepository extends JpaRepository<Varierity, Long> {
}
