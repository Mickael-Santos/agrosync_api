package com.mickaelsantos.apiagrosync.modules.farm.usecases;

import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFarmRequestDto;
import com.mickaelsantos.apiagrosync.modules.farm.repositories.FarmRepository;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFarmResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.models.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mickaelsantos.apiagrosync.exceptions.UserFoundException;

@Service
public class CreateFarmUseCase {

    @Autowired
    private FarmRepository farmRepository;

    public CreateFarmResponseDto execute(CreateFarmRequestDto request) {

        farmRepository.findByIdentification(request.getIdentification())
            .ifPresent(farm -> {
                    throw new UserFoundException();
            });

        Farm farm = Farm.builder()
            .name(request.getName())
            .identification(request.getIdentification())
            .stateRegistration(request.getStateRegistration())
            .build();

        Farm savedFarm = farmRepository.save(farm);
        return CreateFarmResponseDto.builder()
            .id(savedFarm.getId())
            .name(savedFarm.getName())
            .identification(savedFarm.getIdentification())
            .stateRegistration(savedFarm.getStateRegistration())
            .build();
    }
}
