import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){

        /*

        JPA 코드의 흐름
        1. Persistence 객체에서 ORM 설정 정보를 조회 (jpabook 이름으로 된 영속성-유닛을 찾음)
            1-1. Persistence 객체는 EntityManagerFactory를 생성해서 JPA를 사용 할 수 있도록 준비
            1-2. 구현체 즉 ORM Framwork에 따라서 커넥션 풀도 생성  (hibernate -> Hikari connection pool)
        2. EntityFactory에서 EntityManager를 생성
            2-1. JPA의 기능 대부분은 이 EntityManager가 제공 (CRUD)
            2-2. EntityManager는 DataSource를 유지하면서 Databse와 통신한다. (DB Connection과 밀접한 연관성으로 스레드 간에 공유 하거나 재사용 할 수 없다.)
        3. 트랜잭션 관리
            3-1. 비즈니스 로직안에서 CRUD를 수행하기 때문에 항상 트랜잭션을 사용해야한다.
            3-2. 수행도중 예외가 발생하면 롤백
        4. 사용이 끝난 엔티티 매니저는 close() 메소드를 사용해 반드시 종료.
        */


        // ===== 엔티티 매니저 설정 부분 =====
        // 엔티티 매니저 팩토리 - 생성 (DB와의 Connection 관리 부분)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // 엔티티 매니저 - 생성 (DB에 CRUD 명령 즉 쿼리문을 생성하고 실행하는 객체)
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 - 획득 (트랜잭션의 시작과 끝을 관리)
        EntityTransaction tx = em.getTransaction();


        // ===== 트랜잭션 관리 부분 =====
        try {
            tx.begin(); // 트랜잭션 시작
            /*
            String id = "id1";
            Member member = new Member();
            member.setId(id);
            member.setUsername("지한");
            member.setAge(2);
            // C (등록)
            em.persist(member);
            // U (수정)
            member.setAge(20);
            // R (조회)
            Member findMember = em.find(Member.class, id); // id로 조회 및 Member.class 엔티티로 매핑해서 리턴
            System.out.println("한 건 조회  id : " + findMember.getId() +"\nname : " + findMember.getUsername() + "\nage : " +findMember.getAge());
            // R (목록 조회)
            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            System.out.println("members size : " + members.size());
            // D (삭제)
            em.remove(member);
            */

            logic(em); // service logic(bussiness logic 메소드 호출)


            tx.commit(); // 트랜잭션 커밋
            
        } catch (Exception e){ // 트랜잭션 중 오류 나면 rollback
            tx.rollback();

        }finally {
            em.close(); // finally로 EntityManager 종료
        }
        emf.close(); // entityManagerFactory 종료
    }

    // ===== business logic(비즈니스 로직) =====
    // CRUD
    // error call stack 시 예외 rollback 예외 처리
    private static void logic(EntityManager em){
        // test 인스턴스
        // API 개발시 DTO 또는 객체를 넣음
        // Controller에서 REST API 요청 받아옴. MemberRequestDto(username, age), Member, Front에 리턴 시 MemberResponseDto(username, age)

        // 객체 생성 logic
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        // 객체 EntityManager em

        // C (등록)
        // em의 영속성 컨텍스트의 1차 캐시(Map<>)에 member객체 등록
        // Heap | em -> PersistenceCon0text -> 1차 Cache Map{ id1 : member }
        // persist() 메소드 호출 시 영속성 컨텍스트에만 올림
        // 즉, 메모리 Heap의 1차캐시에서 유지중 | INSERT 쿼리를 DB에 보내지 않음
        // EntityManager 즉 em은 영속성 컨텍스트의 내부 쿼리 저장소에 INSERT SQL을 모아 놓음
        // 영속성 컨텍스트 - 쓰기 지연 SQL 저장소
        em.persist(member);

        // 쓰기 지연
        // commit(), flush() 메소드 호출시에 INSERT 쿼리 날림
        // tx.commit();
        // em.flush();

        // U (수정)
        //
        member.setAge(20);
        
        // R (조회)
        // find() 메소드 구조
        // public <T> T find(Class<T> entityClass, Object primaryKey);
        // 리턴 타입 : <T>
        // 첫 번째 파라미터 : 리턴 타입 지정 및 1차캐시 존재여부 확인 후 DB에서 찾음
        // 두 번째 파라미터 : find 할 엔티티의 PK
        //===================================================
        // find() 메소드 흐름 
        // find() 호출 시 영속성 컨텍스트이 1차 캐시에서 조회
        // 존재하면 인스턴스 가져옴
        // 존재하지 않으면 DB에 쿼리 날려서 1차 캐시에 올리고 가져옴
        //===================================================
        // 1차 캐시가 존재하므로 동일성 조회가 가능 (힙 비교)
        Member findMember = em.find(Member.class, id); // id로 조회 및 Member.class 엔티티로 매핑해서 리턴
        System.out.println("Object 조회  id : " + findMember.getId() +"\nname : " + findMember.getUsername() + "\nage : " +findMember.getAge());

        // R (목록 조회)
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members size : " + members.size());

        // D (삭제)
        em.remove(member);
    }
}
/*
        Connection connection = DriverManager.getConnection("","","");
        PreparedStatement ps = connection.prepareStatement("");
        ResultSet rs = ps.executeQuery();

        같은 JDBC로 DB 접근 기술을 처음 배울때 같은 느낌.
        왜인지는 모르지만 일단,
        객체 관리자 공장을 생성
        후 팩토리 안에서 객체 관리자를 만들어서 객체 관리자 객체에게 리턴
        여기서 또 왜인지는 모르겠지만 엔티티 관리자가 트랜잭션을 획득
        객체 트랜잭션에게 리턴
*/