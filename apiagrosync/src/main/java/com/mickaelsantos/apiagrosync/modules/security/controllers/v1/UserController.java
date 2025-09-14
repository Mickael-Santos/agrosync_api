package com.mickaelsantos.apiagrosync.modules.security.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mickaelsantos.apiagrosync.modules.security.dtos.CreateUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.CreateUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.DeleteUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.UpdateUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.UpdateUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.security.usecases.CreateUserUseCase;
import com.mickaelsantos.apiagrosync.modules.security.usecases.DeleteUserUseCase;
import com.mickaelsantos.apiagrosync.modules.security.usecases.UpdateUserUseCase;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private DeleteUserUseCase deleteUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateUserRequestDto requestDTO) {
        try {
            CreateUserResponseDto response = createUserUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UpdateUserRequestDto requestDTO) {
        try {
            UpdateUserResponseDto response = updateUserUseCase.execute(requestDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            DeleteUserResponseDto response = deleteUserUseCase.execute(id);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
