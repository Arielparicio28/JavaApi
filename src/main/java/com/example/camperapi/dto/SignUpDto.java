package com.example.camperapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpDto {
    private Long id;
    private Long camperId;
    private Long activityId;
    private Integer time;
}
