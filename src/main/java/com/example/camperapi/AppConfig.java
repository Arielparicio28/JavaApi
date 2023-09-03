package com.example.camperapi;

import org.modelmapper.ModelMapper;

public class AppConfig {

    //@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
