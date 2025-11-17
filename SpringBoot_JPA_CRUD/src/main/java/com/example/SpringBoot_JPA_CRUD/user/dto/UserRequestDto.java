package com.example.SpringBoot_JPA_CRUD.user.dto;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    private Integer age;
    private String teamName;

    public User toEntity(Team team){
        return new User(name, age, team);
    }
}