package com.mickaelsantos.apiagrosync.modules.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserResponseDto {
    private Long id;
    private String username;
    private String email;
    private boolean isAdmin;
    private Long farmId;
}
