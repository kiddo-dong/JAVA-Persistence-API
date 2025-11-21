package com.example.JPA_Springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
@NamedQuery(name = "Member.findByUsername", query = "select m from Member m Where m.name = :name")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
