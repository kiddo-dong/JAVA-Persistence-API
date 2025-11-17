package com.example.SpringBoot_JPA_CRUD.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    public UserResponseDto(){};

    public UserResponseDto(String name, Integer age, String teamName) {
        this.name = name;
        this.age = age;
        this.teamName = teamName;
    }

    private String name;
    private Integer age;
    private String teamName;
}
