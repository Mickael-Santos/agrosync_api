package com.mickaelsantos.apiagrosync.modules.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserRequestDto {
    private String username;
    private String password;
}
