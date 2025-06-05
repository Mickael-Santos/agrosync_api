package com.mickaelsantos.apiagrosync.modules.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthAdminResponseDto {
    private String acessToken;
    private Long expiresIn;
}
