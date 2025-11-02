package com.example.RelationshipMapping_UserCRUD.users;

import com.example.RelationshipMapping_UserCRUD.posts.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private String age;

    private List<Post> posts = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // C
    public void addPost(Post post){
        posts.add(post);
        post.setUser(this);
    }

    // R

    // U

    // D
    public void deletePost(EntityManager em, Post){

    }
}