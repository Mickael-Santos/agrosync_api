package com.mickaelsantos.api_agrosync.modules.farm.repositories;

import com.mickaelsantos.api_agrosync.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
