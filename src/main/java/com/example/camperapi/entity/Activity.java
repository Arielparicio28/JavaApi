package com.example.camperapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Activity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer difficulty;

    @OneToMany(mappedBy = "activity")
    private List<SignUp> signups;

}
