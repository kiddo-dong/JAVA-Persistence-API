package com.example.RelationshipMapping_CRUD.user.repository;

import com.example.RelationshipMapping_CRUD.user.entity.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}
