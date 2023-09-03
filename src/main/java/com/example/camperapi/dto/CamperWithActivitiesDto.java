package com.example.camperapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CamperWithActivitiesDto {

    private Long id;
    private String name;
    private int age;
    private List<ActivityDto> activities;
}
