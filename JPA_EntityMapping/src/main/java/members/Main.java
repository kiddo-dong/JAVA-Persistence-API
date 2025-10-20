package members;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        
        // EntityManager 생성
        // EntityManager 내부 동작으로 트랜잭션 & 영속성 컨텍스트(1차 캐시, EntityEntry(SnapShot), 쓰기 지연 SQL 저장소) 생성
        EntityManager em = emf.createEntityManager();
        // em의 트랜잭션 가져옴
        EntityTransaction tx = em.getTransaction();

        Member member = new Member();
        member.setUsername("dksl");
        member.setAge(24);
        member.setRoleType(RoleType.USER);

        System.out.println("TEXT 입력 : ");

        member.setDescription(sc.nextLine());


        try {
            tx.begin();

            em.persist(member);

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
