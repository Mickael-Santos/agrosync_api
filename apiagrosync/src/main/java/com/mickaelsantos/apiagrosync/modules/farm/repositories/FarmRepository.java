
package com.mickaelsantos.apiagrosync.modules.farm.repositories;

import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    Optional<Farm> findByIdentification(String identification);

    Optional<Farm> findById(Long id);
}
