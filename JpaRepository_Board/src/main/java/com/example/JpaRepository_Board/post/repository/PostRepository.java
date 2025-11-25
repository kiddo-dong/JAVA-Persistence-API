package com.example.JpaRepository_Board.post.repository;

import com.example.JpaRepository_Board.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 공통 JPA 메소드 상속


}
