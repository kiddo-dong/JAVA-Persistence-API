package com.example.RelationshipMapping_CRUD.user.mapper;

import com.example.RelationshipMapping_CRUD.user.dto.UserRequestDto;
import com.example.RelationshipMapping_CRUD.user.dto.UserResponseDto;
import com.example.RelationshipMapping_CRUD.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "team", ignore = true)
    User toEntity(UserRequestDto userRequestDto);

    @Mapping(source = "team.name", target = "teamName")
    UserResponseDto toResponseDto(User user);

    List<UserResponseDto> toResponseDtoList(List<User> users);
}
