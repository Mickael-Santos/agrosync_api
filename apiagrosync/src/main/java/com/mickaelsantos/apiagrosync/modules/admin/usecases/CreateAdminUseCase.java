package com.mickaelsantos.apiagrosync.modules.admin.usecases;

import com.mickaelsantos.apiagrosync.modules.admin.dtos.CreateAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.CreateAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.models.Admin;
import com.mickaelsantos.apiagrosync.modules.admin.repositories.AdminRepository;
import com.mickaelsantos.apiagrosync.exceptions.dtos.AdminFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateAdminUseCase {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreateAdminResponseDto execute(CreateAdminRequestDto requestDTO) {

        adminRepository.findByEmail(requestDTO.getEmail())
            .ifPresent(admin -> {
                throw new AdminFoundException();
            });

        Admin admin = Admin.builder()
                .username(requestDTO.getUsername())
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .build();

        Admin savedAdmin = adminRepository.save(admin);

        return CreateAdminResponseDto.builder()
                .id(savedAdmin.getId())
                .username(savedAdmin.getUsername())
                .email(savedAdmin.getEmail())
                .build();
    }
}
