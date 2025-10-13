import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        // 엔티티 매니저 팩토리 - 생성
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

        // 엔티티 매니저 생성
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 트랜잭션 획득
        EntityTransaction entityTransaction = entityManager.getTransaction();

    }

    // service logic
    private static void logic(EntityManager entityManager){

    }
}
