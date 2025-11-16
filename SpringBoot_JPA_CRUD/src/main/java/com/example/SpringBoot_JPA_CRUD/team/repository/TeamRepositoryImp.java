package com.example.SpringBoot_JPA_CRUD.team.repository;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TeamRepositoryImp implements TeamRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public void addTeam(Team team) {
        em.persist(team);
    }
    
    // 팀 & 팀의 유저
    @Override
    public Team findByName(String name) {
        String jpql = "SELECT t FROM Team t LEFT JOIN FETCH t.users WHERE t.name = :name";
        List<Team> result = em.createQuery(jpql, Team.class)
                .setParameter("name", name)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // 전체 팀 목록
    @Override
    public List<TeamResponseDto> findAll() {
        String jpql = "SELECT new com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto(t.name) " +
                "from Team t";

        return em.createQuery(jpql,TeamResponseDto.class)
                .getResultList();
    }

    @Override
    public Team updateTeamName(String name) {
       String jpql = "SELECT t FROM Team t WHERE t.name = :name";
       return em.createQuery(jpql, Team.class)
               .setParameter("name", name)
               .getSingleResult();
    }

    @Override
    public void deleteTeam(Team team) {
        em.remove(team);
    }
}
