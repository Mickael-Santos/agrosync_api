package com.mickaelsantos.apiagrosync.modules.user.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mickaelsantos.apiagrosync.modules.user.dtos.DeleteUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.user.repositories.UserRepository;
import com.mickaelsantos.apiagrosync.exceptions.UserNotFoundException;

@Service
public class DeleteUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public DeleteUserResponseDto execute(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        try {
            userRepository.deleteById(id);
            return DeleteUserResponseDto.builder()
                    .message("Usuário deletado com sucesso")
                    .isDeleted(true)
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return DeleteUserResponseDto.builder()
                    .message("Ocorreu um problema ao deletar o usuário!")
                    .isDeleted(false)
                    .build();
        }
    }
}
