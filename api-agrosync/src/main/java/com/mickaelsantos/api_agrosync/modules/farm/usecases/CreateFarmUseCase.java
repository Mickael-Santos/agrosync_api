package com.mickaelsantos.api_agrosync.modules.farm.usecases;

import com.mickaelsantos.api_agrosync.modules.farm.dtos.CreateFarmRequestDto;
import com.mickaelsantos.api_agrosync.modules.farm.repositories.FarmRepository;
import com.mickaelsantos.api_agrosync.modules.farm.dtos.CreateFarmResponseDto;
import com.mickaelsantos.api_agrosync.modules.farm.models.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mickaelsantos.api_agrosync.exceptions.UserFoundException;

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
