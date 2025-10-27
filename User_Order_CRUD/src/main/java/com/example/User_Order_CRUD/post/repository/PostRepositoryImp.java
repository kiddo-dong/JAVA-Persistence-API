package com.example.User_Order_CRUD.post.repository;

import com.example.User_Order_CRUD.post.domain.Post;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PostRepositoryImp implements PostRepository{
    private final EntityManager em;

    public PostRepositoryImp(EntityManager em) {
        this.em = em;
    }

    // CRUD
    public void save(Post post){
        em.persist(post);
    }



}