package com.mickaelsantos.apiagrosync.modules.farm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFarmRequestDto;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.CreateFarmResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.ToggleFarmResponseDto;
import com.mickaelsantos.apiagrosync.modules.farm.usecases.CreateFarmUseCase;
import com.mickaelsantos.apiagrosync.modules.farm.usecases.ToggleFarmUseCase;
import com.mickaelsantos.apiagrosync.modules.farm.usecases.UpdateFarmUseCase;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.UpdateFarmRequestDto;
import com.mickaelsantos.apiagrosync.modules.farm.dtos.UpdateFarmResponseDto;

@RestController
@RequestMapping("/api/v1/farm")
public class FarmController {

    @Autowired
    private CreateFarmUseCase createFarmUseCase;

    @Autowired
    private UpdateFarmUseCase updateFarmUseCase;
    
    @Autowired
    private ToggleFarmUseCase toggleFarmUseCase;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateFarmRequestDto requestDTO) {
        try {
            CreateFarmResponseDto response = createFarmUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UpdateFarmRequestDto requestDTO) {
        try {
            UpdateFarmResponseDto response = updateFarmUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping("/toggle/{id}")
    public ResponseEntity<Object> toggle(@PathVariable Long id) {
        try {
            ToggleFarmResponseDto response = toggleFarmUseCase.execute(id);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
