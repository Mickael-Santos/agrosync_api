package com.mickaelsantos.apiagrosync.modules.field.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.mickaelsantos.apiagrosync.modules.field.dtos.CreateFieldRequestDto;
import com.mickaelsantos.apiagrosync.modules.field.dtos.CreateFieldResponseDto;
import com.mickaelsantos.apiagrosync.modules.field.usecases.CreateFieldUseCase;

@RestController
@RequestMapping("/api/v1/field")
public class FieldController {

    @Autowired
    private CreateFieldUseCase createFieldUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateFieldRequestDto requestDTO) {
        try {
            CreateFieldResponseDto response = createFieldUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
