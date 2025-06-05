package com.mickaelsantos.apiagrosync.modules.farm.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mickaelsantos.apiagrosync.exceptions.FarmNotFoundException;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.ToggleFarmResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;
import com.mickaelsantos.apiagrosync.modules.farm.repositories.FarmRepository;

@Service
public class ToggleFarmUseCase {

    @Autowired
    private FarmRepository farmRepository;

    public ToggleFarmResponseDto execute(Long id) {

        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new FarmNotFoundException());

        if (farm.isActive()) {
            farm.setActive(false);
        } else {
            farm.setActive(true);
        }

        Farm toggledFarm = farmRepository.save(farm);

        return ToggleFarmResponseDto.builder()
                .id(toggledFarm.getId())
                .name(toggledFarm.getName())
                .identification(toggledFarm.getIdentification())
                .stateRegistration(toggledFarm.getStateRegistration())
                .active(toggledFarm.isActive())
                .build();
    }
}
