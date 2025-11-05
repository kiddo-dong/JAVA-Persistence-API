<h2>JPQL(Java Persistence Query Language)</h2>
    - 테이블이 아닌 엔티티를 대상으로 하는 객체 지향 쿼리
    - SQL을 추상화 해서 특정 DB에 의존하지 않음
</br>
<h3>JPA가 지원하는 객체 지향 쿼리 종류</h3>
  - JPQL
  - Criteria Query
  - Native SQL

<h3>JPQL</h3>
  - 엔티티 객체를 조회하는 객체지향 쿼리
  - SQL 추상화를 통해 데이터베이스에 의존하지 않으며 Dialect만 변경하면 DB변경이 용이
  - SQL 기반으로 만들어져 SQL과 비슷함

<h3>JPQL 문법</h3>
  - SELECT
  - UPDATE
  - DELETE