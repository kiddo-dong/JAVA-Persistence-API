package com.example.JPA_Springboot.user.mapper;

import com.example.JPA_Springboot.user.dto.UserRequestDto;
import com.example.JPA_Springboot.user.dto.UserResponseDto;
import com.example.JPA_Springboot.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // toEntity
    User toEntity(UserRequestDto userRequestDto);

    // toDto
    UserResponseDto toResponseDto(User user);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserRequestDto userRequestDto, @MappingTarget User user);
}