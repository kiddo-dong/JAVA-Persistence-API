package com.example.SpringBoot_JPA_CRUD.team.service;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;

public interface TeamService {
    String addTeam(Team team);
    TeamWithUserResponseDto findTeamAndUser(String name);
    String updateTeamName(String name);
    String deleteTeam(String name);
}