package com.example.SpringBoot_JPA_Repository.boilerplate.repository;

import com.example.JPA_Springboot.dto.MemberResponseDto;
import com.example.JPA_Springboot.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public void addMamber(Member member){
        em.persist(member);
    }

    public Member findById(Long id){
        return em.find(Member.class, id);
    }

    public List<MemberResponseDto> allMemeber(){
        String jpql = "select new com.example.JPA_Springboot_User.boilerplate.dto.MemberResponseDto(m.name, m.age) from Member m";

        return em.createQuery(jpql, MemberResponseDto.class)
                .getResultList();
    }

    public Member updateMember(Long id){
        return this.findById(id);
    }

    public void deleteById(Long id){
        em.remove(id);
    }
}