package com.mickaelsantos.apiagrosync.modules.admin.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mickaelsantos.apiagrosync.modules.admin.dtos.UpdateAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.UpdateAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.models.Admin;
import com.mickaelsantos.apiagrosync.modules.admin.repositories.AdminRepository;
import com.mickaelsantos.apiagrosync.exceptions.AdminNotFoundException;

@Service
public class UpdateAdminUseCase {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UpdateAdminResponseDto execute(UpdateAdminRequestDto requestDTO) {
        Admin admin = adminRepository.findById(requestDTO.getId())
                .orElseThrow(() -> {
                    throw new AdminNotFoundException();
                });

        admin.setUsername(requestDTO.getUsername());
        admin.setEmail(requestDTO.getEmail());
        admin.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        Admin updatedAdmin = adminRepository.save(admin);

        return UpdateAdminResponseDto.builder()
                .id(updatedAdmin.getId())
                .username(updatedAdmin.getUsername())
                .email(updatedAdmin.getEmail())
                .build();
    }
}
