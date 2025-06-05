package com.mickaelsantos.apiagrosync.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mickaelsantos.apiagrosync.modules.user.dtos.AuthUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.user.dtos.AuthUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.user.usecases.AuthUserUseCase;

@RestController
@RequestMapping("/api/v1/user")
public class AuthUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> create(@RequestBody AuthUserRequestDto requestDTO) {
        try {
            AuthUserResponseDto response = authUserUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
