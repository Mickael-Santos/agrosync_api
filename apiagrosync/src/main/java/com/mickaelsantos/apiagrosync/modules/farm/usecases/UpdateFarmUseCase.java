package com.mickaelsantos.apiagrosync.modules.farm.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mickaelsantos.apiagrosync.modules.farm.dtos.UpdateFarmRequestDto;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.UpdateFarmResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.repositories.FarmRepository;
import com.mickaelsantos.apiagrosync.exceptions.FarmNotFoundException;

@Service
public class UpdateFarmUseCase {
    @Autowired
    private FarmRepository farmRepository;

    public UpdateFarmResponseDto execute(UpdateFarmRequestDto requestDTO) {
        var farm = farmRepository.findById(requestDTO.getId())
                .orElseThrow(() -> {
                    throw new FarmNotFoundException();
                });

        farm.setName(requestDTO.getName());
        farm.setIdentification(requestDTO.getIdentification());
        farm.setStateRegistration(requestDTO.getStateRegistration());

        var updatedFarm = farmRepository.save(farm);

        return UpdateFarmResponseDto.builder()
                .id(updatedFarm.getId())
                .name(updatedFarm.getName())
                .identification(updatedFarm.getIdentification())
                .stateRegistration(updatedFarm.getStateRegistration())
                .build();
    }
}