import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // JPA 생성 및 사용
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // JVM 메모리 힙에 올림
        // 객체 관계 연결 후 영속성에 등록
        User user1 = new User("User1",23);
        Post post1 = new Post("PostTitle1", "PostContent1");
        Post post2 = new Post("PostTitle2", "PostTitle2");

        // 영속성에 등록 후 객체 관계 연결
        User user2 = new User("User2",23);
        Post post3 = new Post("PostTitle3", "PostContent1");
        Post post4 = new Post("PostTitle4", "PostTitle2");

        // 예외 처리
        try {
            tx.begin();
            // 1차 캐시 등록 (영속성 컨텍스트)
            // 객체 관계 연결 후 등록
            user1.addPost(post1);
            user1.addPost(post2);
            em.persist(user1);
            em.persist(post1);
            em.persist(post2);

            // 등록 후 객체 관계 연결
            em.persist(user2);
            em.persist(post3);
            em.persist(post4);

            post3.setUser(user2);
            post4.setUser(user2);

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
