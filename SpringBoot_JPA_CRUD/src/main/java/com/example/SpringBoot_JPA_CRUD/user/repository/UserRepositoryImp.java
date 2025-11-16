package com.example.SpringBoot_JPA_CRUD.user.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    EntityManager em;


}
