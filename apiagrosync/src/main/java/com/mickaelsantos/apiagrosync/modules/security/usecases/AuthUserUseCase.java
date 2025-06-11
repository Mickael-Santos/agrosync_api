package com.mickaelsantos.apiagrosync.modules.security.usecases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mickaelsantos.apiagrosync.exceptions.UserNotFoundException;
import com.mickaelsantos.apiagrosync.modules.security.dtos.AuthUserRequestDto;
import com.mickaelsantos.apiagrosync.modules.security.dtos.AuthUserResponseDto;
import com.mickaelsantos.apiagrosync.modules.security.models.User;
import com.mickaelsantos.apiagrosync.modules.security.repositories.UserRepository;

@Service
public class AuthUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${spring.security.secret}")
    private String secretKey;

    @Value("${spring.security.issuer}")
    private String issuer;

    public AuthUserResponseDto execute(AuthUserRequestDto requestDTO) throws AuthenticationException {
        User user = userRepository.findByUsername(requestDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        var passwordMatches = passwordEncoder.matches(requestDTO.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Incorrect password");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofDays(5));

        var role = "USER";
        if (user.isAdmin()) {
            role = "ADMIN";
        }

        var token = JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(expiresIn)
                .withClaim("roles", Arrays.asList(role))
                .withSubject(user.getId().toString())
                .sign(algorithm);

        return AuthUserResponseDto.builder()
                .acessToken(token)
                .expiresIn(expiresIn.toEpochMilli())
                .build();
    }
}
