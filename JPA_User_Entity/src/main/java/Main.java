import jakarta.persistence.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // JPA 호출(EM) 및 영속성 컨텍스트(1차 캐시, SQL 쓰기 지연 저장소, EntityEntry) 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQLPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
/*
        User 객체 생성 logic
        User user = new User();
        user.setUsername("ㅇㅇ");
        user.setAge(30);
        System.out.println("Content 입력 : ");
        user.setContent(sc.nextLine());
*/
        User user = new User();
        try {
            tx.begin();
            /*
            // findUserById
            user = em.find(User.class,1L);
            System.out.println(user.getId() + " || " + user.getUsername());

            // updateUserById
            user.setUsername("진짜동현");
            */
            
            // 준영속
            em.detach(user);

            user = em.find(User.class, 2L);
            em.remove(user);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
