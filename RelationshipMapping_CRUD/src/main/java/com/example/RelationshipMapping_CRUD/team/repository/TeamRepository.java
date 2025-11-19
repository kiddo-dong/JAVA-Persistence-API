package com.example.RelationshipMapping_CRUD.team.repository;

import com.example.RelationshipMapping_CRUD.team.entity.Team;

public interface TeamRepository {
    Team findByName(String name);
}
