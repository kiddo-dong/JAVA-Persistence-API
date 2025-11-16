package com.example.SpringBoot_JPA_CRUD.team.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponseDto {

    public TeamResponseDto(String name) {
        this.name = name;
    }

    private String name;
}
