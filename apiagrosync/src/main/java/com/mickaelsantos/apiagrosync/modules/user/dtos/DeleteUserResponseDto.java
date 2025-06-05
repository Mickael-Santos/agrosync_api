package com.mickaelsantos.apiagrosync.modules.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteUserResponseDto {
    private String message;
    private boolean isDeleted;
}
