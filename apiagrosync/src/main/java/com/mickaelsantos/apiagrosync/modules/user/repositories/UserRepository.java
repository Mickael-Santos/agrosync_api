package com.mickaelsantos.apiagrosync.modules.user.repositories;

import com.mickaelsantos.apiagrosync.modules.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
