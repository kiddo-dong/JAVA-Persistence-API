package com.example.SpringBoot_JPA_CRUD.team.dto;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequestDto {
    private String name;

    public Team toEntity(){
        return new Team(name);
    }
}
