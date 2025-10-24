package com.example.JPA_Springboot_User.controller;

import com.example.JPA_Springboot_User.domain.UserRequestDTO;
import com.example.JPA_Springboot_User.domain.UserResponseDto;
import com.example.JPA_Springboot_User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserRequestDTO userRequestDTO){
        userService.addUser(userRequestDTO);
        Map<String, String> result = new HashMap<>();
        result.put("message", "Successfully");

        return ResponseEntity
                .ok(result);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser(){

        return ResponseEntity
                .ok(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){
        UserResponseDto dto = userService.findUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return ResponseEntity.ok(dto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateUserById(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        userService.updateUserById(id, userRequestDTO);
        Map<String, String> result = new HashMap<>();
        result.put("message", "Successfully");

        return ResponseEntity
                .ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteUsetById(@PathVariable Long id){
        userService.deleteUserById(id);
        Map<String, String> result = new HashMap<>();
        result.put("message", "Successfully");

        return ResponseEntity
                .ok(result);
    }

}