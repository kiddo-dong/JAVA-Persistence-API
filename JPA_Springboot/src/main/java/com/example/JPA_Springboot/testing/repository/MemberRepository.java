package com.example.JPA_Springboot.testing.repository;

import com.example.JPA_Springboot.testing.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// interface
// Spring Data JPA가 구현체 자동 생성
// RunTime 시점에서 구현체를 SprinDataJPA가 주입해줌

//JpaRepository<Objcet, PK_Type> interface를 상속 받아야 함

// JpaRepository 인터페이스의 상속
// Spring Data의 프로젝트 중 하나인 Spring Data를 상속 받는다

// 상속 순서
// Spring Data
// <<Interface>> Repository
// <<Interface>> CrudRepository
// <<Interface>> PagingAndSortingRepository
// Spring Data JPA
// <<Interface>>JpaRepository<T,ID extends Serializable>
// 총 4번의 상속을 거침

// Spring Data JPA가 제네릭의 타입과 @ID를 읽어 공통 메소드의 구현체에 해당 엔티티 ID를 붙여줌
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 일반적일 CRUD 메소는 Spring DATA JPA의 JpaRepository 인터페이스가 공통으로 제공
    /*
    JpaRepository.INSTANCE.save();
    JpaRepository.INSTANCE.findOne();
    JpaRepository.INSTANCE.findAll();
    등등
    */

    // jpa 사용 ex)
    // 메소드명이 JpaRepository가 주는 공통 메소드가 아닌 메소드
    // Spring Data JPA가 메소드 명을  분석해서 JPQL을 실행해줌

    // findOne
    Member findByName(String name);

    // Spring Data JPA의 해당 메소드 JPQL 처리
    // select m from Member m where username = :username

    // JpaRepository의 메소드 (공통)
    // save[Entity & Super]
    // delete[Entity]
    // findOne[ID]
    // getOne[ID]
    // findAll()

    // Create new Data
    // save() 메소드의 내부 동작
    // 1. if문으로 엔티티가 @ID(식별자) 값이 존재하는지 확인
    // 2-1. 식별자가 존재하면 marge()로 엔티티를 1차캐시에 올려줌.
    // 2-2. 식별자가 존재하지 않는다면 새 객체이다.(모든 엔티티는 식별자를 가지기 때문)
    // 3. save/update 가능

    //@Override 된 메소드들 확인해보기
    // ctrl + O 로 Override 된 메소드들의 목록을 볼 수 있다.
    // 4개의 상속계층을 거치면서 다양하고 많은 메소드가 존재하는 것을 볼 수 있다.
}