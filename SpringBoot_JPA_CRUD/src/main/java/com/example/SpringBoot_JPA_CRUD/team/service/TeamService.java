package com.example.SpringBoot_JPA_CRUD.team.service;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamRequestDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeamService {
    String addTeam(TeamRequestDto teamRequestDto);
    TeamWithUserResponseDto findTeamAndUser(String name);
    List<TeamResponseDto> findAll();
    String updateTeamName(String name, String newName);
    String deleteTeam(String name);
}