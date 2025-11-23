package com.example.JPA_Springboot.user.repository;

import com.example.JPA_Springboot.user.dto.UserRequestDto;
import com.example.JPA_Springboot.user.dto.UserResponseDto;
import com.example.JPA_Springboot.user.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // @Query 사용
    // select all
    @Query("select new com.example.JPA_Springboot.user.dto.UserResponseDto(u.name, u.age) from User u")
    List<UserResponseDto> findAllTransDto();
}