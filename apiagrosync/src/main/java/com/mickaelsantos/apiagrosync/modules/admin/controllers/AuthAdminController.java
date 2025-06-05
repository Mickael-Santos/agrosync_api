package com.mickaelsantos.apiagrosync.modules.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mickaelsantos.apiagrosync.modules.admin.dtos.AuthAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.AuthAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.usecases.AuthAdminUseCase;

@RestController
@RequestMapping("/api/v1/admin")
public class AuthAdminController {

    @Autowired
    private AuthAdminUseCase authAdminUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> create(@RequestBody AuthAdminRequestDto requestDTO) {
        try {
            AuthAdminResponseDto response = authAdminUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
