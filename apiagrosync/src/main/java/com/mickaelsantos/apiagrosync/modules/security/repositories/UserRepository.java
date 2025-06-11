package com.mickaelsantos.apiagrosync.modules.security.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mickaelsantos.apiagrosync.modules.security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
