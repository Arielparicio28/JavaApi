package com.example.camperapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CamperResponseDto {

    private Long id;
    private String name;
    private Integer age;

}
