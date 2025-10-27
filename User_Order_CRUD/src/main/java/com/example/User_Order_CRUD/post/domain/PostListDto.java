package com.example.User_Order_CRUD.post.domain;

import com.example.User_Order_CRUD.user.domain.User;

import java.time.LocalDateTime;

public class PostListDto {
    private Long id;
    private String name;
    private String title;
    private LocalDateTime updatedAt;

    public PostListDto(){};

    public PostListDto(Long id, String name, String title, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
