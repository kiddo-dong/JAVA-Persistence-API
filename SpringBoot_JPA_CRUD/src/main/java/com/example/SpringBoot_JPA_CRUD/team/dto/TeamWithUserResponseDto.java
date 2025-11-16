package com.example.SpringBoot_JPA_CRUD.team.dto;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeamWithUserResponseDto {
    private String name;
    private List<UserResponseDto> userResponseDtos = new ArrayList<>();
}
