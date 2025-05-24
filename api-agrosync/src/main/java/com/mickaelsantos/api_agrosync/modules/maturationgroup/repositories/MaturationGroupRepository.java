package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.maturationgroup.models.MaturationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaturationGroupRepository extends JpaRepository<MaturationGroup, Long> {
}
