package com.mickaelsantos.apiagrosync.modules.maturationgroup.repositories;

import com.mickaelsantos.apiagrosync.modules.maturationgroup.models.MaturationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaturationGroupRepository extends JpaRepository<MaturationGroup, Long> {
}
