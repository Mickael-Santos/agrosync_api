package com.mickaelsantos.apiagrosync.modules.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mickaelsantos.apiagrosync.modules.admin.dtos.CreateAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.CreateAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.DeleteAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.UpdateAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.UpdateAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.usecases.CreateAdminUseCase;
import com.mickaelsantos.apiagrosync.modules.admin.usecases.UpdateAdminUseCase;
import com.mickaelsantos.apiagrosync.modules.admin.usecases.DeleteAdminUseCase;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private CreateAdminUseCase createAdminUseCase;

    @Autowired
    private UpdateAdminUseCase updateAdminUseCase;

    @Autowired
    private DeleteAdminUseCase deleteAdminUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateAdminRequestDto requestDTO) {
        try {
            CreateAdminResponseDto response = createAdminUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UpdateAdminRequestDto requestDTO) {
        try {
            UpdateAdminResponseDto response = updateAdminUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            DeleteAdminResponseDto response = deleteAdminUseCase.execute(id);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
