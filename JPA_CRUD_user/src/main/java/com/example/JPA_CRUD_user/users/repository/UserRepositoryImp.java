package com.example.JPA_CRUD_user.users.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRepositoryImp {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory();
}
