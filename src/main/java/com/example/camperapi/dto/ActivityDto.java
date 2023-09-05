package com.example.camperapi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {


    private Long id;
    @NotBlank(message = "Invalid Activity: Empty")
    @NotNull(message = "Invalid Activity: NULL")
    @Size(min = 3, max = 30, message = "Invalid Activity: Must be of 3 - 30 characters")
    private String name;

    @NotNull(message = "Difficulty field should not be null.")
    @Min(value = 1, message = "Difficulty  should be at least 1.")
    @Max(value = 5, message = "Difficulty  should not exceed 5.")
    private Integer difficulty;

}
