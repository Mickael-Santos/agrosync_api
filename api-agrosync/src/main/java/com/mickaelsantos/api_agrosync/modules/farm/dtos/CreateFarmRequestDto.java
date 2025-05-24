package com.mickaelsantos.api_agrosync.modules.user.dtos;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFarmRequestDto {
    private String name;
    private String identification;
    private String stateRegistration;
}
