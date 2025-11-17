package com.example.SpringBoot_JPA_CRUD.user.entity;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    public User(){}

    public User(String name, Integer age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    // PK
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "age")
        private Integer age;

        // FK
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "team_id")
        private Team team;

        public void setTeam(Team team){
            if(this.team != null){
                this.team.getUsers().remove(this);
            }
            this.team = team;
            team.adduser(this);
        }
}
