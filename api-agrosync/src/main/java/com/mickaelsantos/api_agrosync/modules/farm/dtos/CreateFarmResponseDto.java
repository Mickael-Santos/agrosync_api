package com.mickaelsantos.api_agrosync.modules.farm.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFarmResponseDto {
    private Long id;
    private String name;
    private String identification;
    private String stateRegistration;
}
