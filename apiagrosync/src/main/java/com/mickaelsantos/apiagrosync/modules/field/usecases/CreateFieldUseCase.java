package com.mickaelsantos.apiagrosync.modules.field.usecases;

import com.mickaelsantos.apiagrosync.exceptions.FieldFoundException;
import com.mickaelsantos.apiagrosync.modules.field.dtos.CreateFieldRequestDto;
import com.mickaelsantos.apiagrosync.modules.field.dtos.CreateFieldResponseDto;
import com.mickaelsantos.apiagrosync.modules.field.models.Field;
import com.mickaelsantos.apiagrosync.modules.field.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFieldUseCase {

    @Autowired
    private FieldRepository fieldRepository;

    public CreateFieldResponseDto execute(CreateFieldRequestDto requestDTO) {

        fieldRepository.findByNameAndFarmId(requestDTO.getName(), requestDTO.getFarm_id())
            .ifPresent(field -> {
                throw new FieldFoundException();
            });

        Field field = Field.builder()
            .name(requestDTO.getName())
            .area(requestDTO.getArea())
            .farm_id(requestDTO.getFarm_id())
            .build();

        Field savedField = fieldRepository.save(field);

        return CreateFieldResponseDto.builder()
            .id(savedField.getId())
            .name(savedField.getName())
            .area(savedField.getArea())
            .farm_id(savedField.getFarm_id())
            .build();
    }
}
