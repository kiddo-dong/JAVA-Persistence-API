package com.example.RelationshipMapping_CRUD.user.repository;

import com.example.RelationshipMapping_CRUD.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{

    @PersistenceContext
    EntityManager em;

    // C
    @Override
    public void addUser(User user){
        em.persist(user);
    }

    //R
    @Override
    public User findById(Long id){
        return em.find(User.class,id);
    }

    @Override
    public List<User> findAll(){
        String jpql = "select u from User u";
        return em.createQuery(jpql, User.class).getResultList();
    }

    //D
    @Override
    public void deleteById(Long id){
        String jpql = "select u from User u where u.id = :id";
        em.createQuery(jpql, User.class)
                .setParameter("id", id)
                .executeUpdate();
    }
}