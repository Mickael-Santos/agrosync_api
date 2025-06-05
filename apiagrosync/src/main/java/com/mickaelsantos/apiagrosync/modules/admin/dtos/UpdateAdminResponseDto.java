package com.mickaelsantos.apiagrosync.modules.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAdminResponseDto {
    private Long id;
    private String username;
    private String email;
}
