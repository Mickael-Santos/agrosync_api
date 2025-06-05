package com.mickaelsantos.apiagrosync.modules.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteAdminResponseDto {
    private String message;
    private boolean isDeleted;
}
