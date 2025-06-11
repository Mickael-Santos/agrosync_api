package com.mickaelsantos.apiagrosync.modules.farm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFieldRequestDto;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFieldResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.usecases.CreateFieldUseCase;

@RestController
@RequestMapping("/api/v1/field")
public class FieldController {

    @Autowired
    private CreateFieldUseCase createFieldUseCase;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
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
