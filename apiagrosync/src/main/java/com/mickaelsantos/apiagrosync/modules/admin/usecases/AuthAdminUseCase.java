package com.mickaelsantos.apiagrosync.modules.admin.usecases;

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
import com.mickaelsantos.apiagrosync.exceptions.AdminNotFoundException;
import com.mickaelsantos.apiagrosync.exceptions.UserNotFoundException;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.AuthAdminRequestDto;
import com.mickaelsantos.apiagrosync.modules.admin.dtos.AuthAdminResponseDto;
import com.mickaelsantos.apiagrosync.modules.admin.models.Admin;
import com.mickaelsantos.apiagrosync.modules.admin.repositories.AdminRepository;

@Service
public class AuthAdminUseCase {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${spring.security.secret}")
    private String secretKey;

    @Value("${spring.security.issuer}")
    private String issuer;

    public AuthAdminResponseDto execute(AuthAdminRequestDto requestDTO) throws AuthenticationException {
        Admin admin = adminRepository.findByUsername(requestDTO.getUsername())
                .orElseThrow(() -> {
                    throw new AdminNotFoundException();
                });

        var passwordMatches = passwordEncoder.matches(requestDTO.getPassword(), admin.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Incorrect password");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofDays(5));

        var token = JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(expiresIn)
                .withClaim("roles", Arrays.asList("ADMIN"))
                .withSubject(admin.getId().toString())
                .sign(algorithm);

        return AuthAdminResponseDto.builder()
                .acessToken(token)
                .expiresIn(expiresIn.toEpochMilli())
                .build();
    }
}
