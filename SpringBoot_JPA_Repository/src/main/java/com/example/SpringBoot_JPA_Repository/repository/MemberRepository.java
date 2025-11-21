package com.example.SpringBoot_JPA_Repository.repository;

import com.example.JPA_Springboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// interface
// Spring Data JPA가 구현체 자동 생성
// RunTime 시점에서 구현체를 SprinDataJPA가 주입해줌

//JpaRepository<Objcet, PK_Type> interface를 상속 받아야 함
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 일반적일 CRUD 메소는 Spring DATA JPA의 JpaRepository 인터페이스가 공통으로 제공
    /*
    JpaRepository.INSTANCE.save();
    JpaRepository.INSTANCE.findOne();
    JpaRepository.INSTANCE.findAll();
    등등
    */

    // 메소드명이 JpaRepository가 주는 공통 메소드가 아닌 메소드
    // Spring Data JPA가 메소드 명을  분석해서 JPQL을 실행해줌
    Member findByUsername(Member member);

    // Spring Data JPA의 해당 메소드 JPQL 처리
    // select m from Member m where username = :username
}