package com.example.SpringBoot_JPA_Repository.boilerplate.mapper;

import com.example.JPA_Springboot.dto.MemberRequestDto;
import com.example.JPA_Springboot.dto.MemberResponseDto;
import com.example.JPA_Springboot.entity.Member;

//@Mapper
public interface MemberMapper{
    // Request -> Entity
    Member toEntity(MemberRequestDto memberRequestDto);

    // @mapping(source = "team.name", target = "TeamName")
    MemberResponseDto toResponseDto(Member member);

    // BeanMapping(nullValueStratgy = IGNORE)
    //void (@MappingTarget User user,MemberRequestDto memberRequestDto);
}