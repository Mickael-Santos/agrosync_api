package com.mickaelsantos.apiagrosync.modules.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAdminRequestDto {
    private String username;
    private String email;
    private String password;
}
