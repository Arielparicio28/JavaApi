package com.example.camperapi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "activity")
public class Activity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int difficulty;

  public Activity(){}

}
