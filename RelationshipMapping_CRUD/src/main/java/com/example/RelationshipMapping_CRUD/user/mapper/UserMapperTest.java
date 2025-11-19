package com.example.RelationshipMapping_CRUD.user.mapper;

import com.example.RelationshipMapping_CRUD.user.dto.UserRequestDto;
import com.example.RelationshipMapping_CRUD.user.dto.UserResponseDto;
import com.example.RelationshipMapping_CRUD.user.entity.User;
import org.mapstruct.*;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

// Mapper Class 선언
// Option - Spring Bean으로 등록
@Mapper(componentModel = "spring")
public interface UserMapperTest {
    // DTO to Entity
    User toEntity(UserRequestDto userRequestDto);

    // Entity to DTO
    // 객체에서 추출을 위한 Target 지정(field 기반)
    @Mapping(source = "team.name", target = "teamName")
    UserResponseDto toResponseDto(User user);

    // update Mapping
    // null 타입 무시를 위해 지정
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void UserUpdateFromDto(UserRequestDto userRequestDto, @MappingTarget User user);
}
