package com.mickaelsantos.api_agrosync.modules.farm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.mickaelsantos.api_agrosync.modules.farm.dtos.CreateFarmRequestDto;
import com.mickaelsantos.api_agrosync.modules.farm.dtos.CreateFarmResponseDto;
import com.mickaelsantos.api_agrosync.modules.farm.usecases.CreateFarmUseCase;
import com.mickaelsantos.api_agrosync.exceptions.UserFoundException;

@RestController
@RequestMapping("/api/v1/farm")
public class FarmController {
    @Autowired
    private CreateFarmUseCase createFarmUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateFarmRequestDto request) {
        try {
            CreateFarmResponseDto response = createFarmUseCase.execute(request);
            return ResponseEntity.ok().body(response);
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
