package com.example.JPA_Springboot.springdatajpa.repository;

import com.example.JPA_Springboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
JPA의 3가지 메소드 기능
1. 메소드 이름으로 쿼리 생성
2. 메소드 이름으로 JPA NamedQuery 호출
3. @Query 어노테이션으로 리포지토리 인터페이스에 쿼리 직접 정의
*/

// JpaRepository 상속(4개의 상속을 거침) -> 런타임 시점에서 구현체 자동 생성
public interface QueryCreateFromXXX extends JpaRepository<Member, Long> {

    // 1. 메소드 이름으로 쿼리 생성
    // Spring-data Docs에서 볼 수 있음
    Member findByName(String name);
    Member findByNameAndAge(String name, int age);
    // 등등 매우 많음

    //====================================================================

    // 2. 메소드 이름으로 JPA NamedQuery 호출
    // Spring Data JPA는 메소드 이름으로 JPA Named 쿼리를 호출하는 기능을 제공한다.
    // JPA Named : 쿼리에 이름을 부여해서 호출해서 사용하는 방식 (Mybatis와 유사한 기능)
    // 2가지 방식이 존재

    // @NamedQuery 어노테이션으로 Named 쿼리 정의
    List<Member> findByUsername(@Param("username")String username);

    // 3. @Query, Repository의 메소드에 쿼리를 정의
    @Query("select m from Member m where m.name = ?1") // equal.("m.name = :name") | JPQL 사용
    public Member findByName2(String name);


    @Query(value = "SELECT * FROM member WHERE name = ?0", nativeQuery = true) // Native Query(SQL)
    Member findByName3(String name);
}