package com.example.JPA_Springboot.testing.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class LegacyRepository {
    // 기존에 Repository 즉, DB 접근 기술의 변화

    /*
       순수 JDBC
            |
   Data Source + JDBC (Connection pool | Hikari CP)
            |
  Spring JDBC Tamplate(Hikari CP)
            |
           JPA
            |
        spring DATA JPA
    */

    // 순수 JPA
    // 기존의 JPA는 엔티티 매니저를 생성 및 대부분 JPQL을 이용해서 작성하였다.
    @PersistenceContext
    EntityManager entityManager;

    // CRUD 및 영속성 메소드들
    // public ....
}
