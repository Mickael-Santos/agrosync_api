package com.mickaelsantos.apiagrosync.modules.admin.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mickaelsantos.apiagrosync.modules.admin.dtos.DeleteAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.repositories.AdminRepository;
import com.mickaelsantos.apiagrosync.exceptions.AdminNotFoundException;

@Service
public class DeleteAdminUseCase {

    @Autowired
    private AdminRepository adminRepository;

    public DeleteAdminResponseDto execute(Long id) {
        adminRepository.findById(id)
                .orElseThrow(() -> {
                    throw new AdminNotFoundException(); // Pode criar uma AdminNotFoundException se desejar
                });

        try {
            adminRepository.deleteById(id);
            return DeleteAdminResponseDto.builder()
                    .message("Admin deletado com sucesso")
                    .isDeleted(true)
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return DeleteAdminResponseDto.builder()
                    .message("Ocorreu um problema ao deletar o admin!")
                    .isDeleted(false)
                    .build();
        }
    }
}
