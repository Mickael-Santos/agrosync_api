package com.mickaelsantos.api_agrosync.modules.farm.dtos;

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
