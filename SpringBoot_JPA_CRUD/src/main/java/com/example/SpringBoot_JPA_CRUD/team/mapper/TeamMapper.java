package com.example.SpringBoot_JPA_CRUD.team.mapper;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import org.springframework.web.bind.annotation.Mapping;

public interface TeamMapper {
    TeamWithUserResponseDto toDto(Team team);
    UserResponseDto toUserDto(User user);
}
