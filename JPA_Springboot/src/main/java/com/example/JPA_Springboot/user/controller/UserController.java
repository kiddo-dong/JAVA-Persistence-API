package com.example.JPA_Springboot.user.controller;

import com.example.JPA_Springboot.user.dto.UserRequestDto;
import com.example.JPA_Springboot.user.dto.UserResponseDto;
import com.example.JPA_Springboot.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Mac Mini git
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity
                .ok(userService.addUser(userRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(userService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity
                .ok(userService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity
                .ok(userService.updateUser(id, userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity
                .ok(userService.deleteById(id));
    }
}