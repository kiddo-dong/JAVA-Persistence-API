package com.example.SpringBoot_JPA_CRUD.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private Integer age;
    private String teamName;
}
