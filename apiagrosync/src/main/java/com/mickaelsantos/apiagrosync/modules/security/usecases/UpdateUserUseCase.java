package com.mickaelsantos.apiagrosync.modules.security.usecases;

import com.mickaelsantos.apiagrosync.modules.security.dtos.UpdateUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.UpdateUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.security.models.User;
import com.mickaelsantos.apiagrosync.modules.security.repositories.UserRepository;
import com.mickaelsantos.apiagrosync.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UpdateUserResponseDto execute(UpdateUserRequestDto requestDTO) {
        User user = userRepository.findById(requestDTO.getId())
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setAdmin(requestDTO.isAdmin());
        user.setFarm_id(requestDTO.getFarmId());

        User updatedUser = userRepository.save(user);

        return UpdateUserResponseDto.builder()
                .id(updatedUser.getId())
                .username(updatedUser.getUsername())
                .email(updatedUser.getEmail())
                .isAdmin(updatedUser.isAdmin())
                .farmId(updatedUser.getFarm_id())
                .build();
    }
}
