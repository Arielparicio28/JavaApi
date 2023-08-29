package com.example.camperapi.entity;


import jakarta.persistence.*;
@Entity
@Table(name = "camper")

public class Camper {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String username;
    private String password;

}
