package com.example.camperapi.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "signup")

 public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int camper_id;
    private int activity_id;
    private int time;

}


