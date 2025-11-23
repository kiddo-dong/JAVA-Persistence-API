package com.example.JPA_Springboot.testing.boilerplate.mapper;

import com.example.JPA_Springboot.testing.dto.MemberRequestDto;
import com.example.JPA_Springboot.testing.dto.MemberResponseDto;
import com.example.JPA_Springboot.testing.entity.Member;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface MemberMapper{
    // Request -> Entity
    Member toEntity(MemberRequestDto memberRequestDto);

    @Mapping(source = "team.name", target = "teamName")
    MemberResponseDto toResponseDto(Member member);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void upadteMemberFromDto(MemberRequestDto memberRequestDto, @MappingTarget Member member);
}