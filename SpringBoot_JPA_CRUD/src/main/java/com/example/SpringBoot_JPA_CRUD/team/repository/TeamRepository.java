package com.example.SpringBoot_JPA_CRUD.team.repository;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto;

import java.util.List;

public interface TeamRepository {

    // C
    // Team Create
    void addTeam(Team team);

    //R
    // find Team & Team's User(Team 검색용)
    Team findByName(String name);
    // find Object
    Team findOnlyTeam(String name);
    // find TeamList
    List<TeamResponseDto> findAll();

    // U
    Team updateByName(String name);

    // D
    void deleteTeam(Team team);
}