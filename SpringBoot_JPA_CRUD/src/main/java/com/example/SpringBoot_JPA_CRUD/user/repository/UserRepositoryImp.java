package com.example.SpringBoot_JPA_CRUD.user.repository;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public void addUser(User user){
        em.persist(user);
    }

    @Override
    public UserResponseDto findById(Long id){
        String jpql = "select new com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto(u.name, u.age, t.name) from User u join u.team t where u.id = :id";
        return em.createQuery(jpql, UserResponseDto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<UserResponseDto> findAll(){
        String jpql = "select new com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto(u.name, u.age, t.name) from User u join u.team t";
        return em.createQuery(jpql, UserResponseDto.class)
                .getResultList();
    }

    @Override
    public User updateById(Long id){
        String jpql = "select u from User u where u.id = :id";
        return em.createQuery(jpql,User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void deleteById(Long id){
        String jpql = "delete from User u where u.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }

}
