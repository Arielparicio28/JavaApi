package com.example.camperapi.entity;

import jakarta.persistence.*;
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
    private List<SignUp> signup;

}
