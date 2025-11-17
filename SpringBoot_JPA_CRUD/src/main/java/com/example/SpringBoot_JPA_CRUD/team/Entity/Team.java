package com.example.SpringBoot_JPA_CRUD.team.Entity;

import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {

    protected Team(){}

    public Team(String name) {
        this.name = name;
    }

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<>();

    public void adduser(User user){
        users.add(user);
    }
}
