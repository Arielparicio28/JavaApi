package com.example.camperapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SignUpRequestDto {

    @NotNull(message = "Camper ID must not be null.")
    private Long camperId;


    @NotNull(message = "Activity ID must not be null.")
    private Long activityId;

    @NotNull(message = "Time field must not be null.")
    @Min(value = 0, message = "Time should be between 0 and 23.")
    @Max(value = 23, message = "Time should be between 0 and 23.")
    private Integer time;
}
