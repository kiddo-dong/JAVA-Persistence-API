import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // JPA 생성 및 사용
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        // 예외 처리
        try {
            tx.begin();

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
