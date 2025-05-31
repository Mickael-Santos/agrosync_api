package com.mickaelsantos.apiagrosync.modules.field.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFieldResponseDto {
    private Long id;
    private String name;
    private double area;
    private Long farm_id;
}
