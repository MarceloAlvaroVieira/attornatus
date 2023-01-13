package com.attornatus.config;

import org.springframework.context.annotation.Configuration;

import org.modelmapper.ModelMapper;

@Configuration
public class ModalMapperConnfig {
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
