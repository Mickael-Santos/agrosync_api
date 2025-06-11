package com.mickaelsantos.apiagrosync.modules.farm.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFieldRequestDto {
    private String name;
    private double area;
    private Long farm_id;
}
