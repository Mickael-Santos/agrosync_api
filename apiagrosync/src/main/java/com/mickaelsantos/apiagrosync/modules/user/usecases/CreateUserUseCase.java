package com.mickaelsantos.apiagrosync.modules.user.usecases;

import com.mickaelsantos.apiagrosync.modules.user.dtos.CreateUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.user.dtos.CreateUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.user.models.User;
import com.mickaelsantos.apiagrosync.modules.user.repositories.UserRepository;
import com.mickaelsantos.apiagrosync.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreateUserResponseDto execute(CreateUserRequestDto requestDTO) {

        userRepository.findByEmail(requestDTO.getEmail())
            .ifPresent(user -> {
                throw new UserFoundException();
            });

        User user = User.builder()
                .username(requestDTO.getUsername())
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .farm_id(requestDTO.getFarmId())
                .build();

        User savedUser = userRepository.save(user);

        return CreateUserResponseDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .farmId(savedUser.getFarm_id())
                .build();
    }
}
