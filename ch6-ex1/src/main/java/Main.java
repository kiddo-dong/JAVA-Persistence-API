import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        /*
        해당 로직에서
        User를 먼저 생성한느 이유는 Post는 User에서 발생한 데이터 이므로 User를 생성해서 그 후 게시물의 내용을 넣어줘야한다.
        즉 Post는 혼자 DB에 생성될 수 없다 User 객체가 존재하지 않는다면(User 테이블이 존재하지 않는다면)
        Post데이터도 데이터베이스에 존재 할 수 없다.
        */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // 객체들 생성
        User user = new User("동현", 25);
        Post post1 = new Post("첫 번째 게시글", "내용입니다");
        Post post2 = new Post("두 번째 게시글", "또 다른 내용입니다");

        // user 객체가 게시물 생성
        user.addPost(post1);
        user.addPost(post2);

        // JPA 코드로 persist 처리
        em.persist(user);
        em.persist(post1);
        em.persist(post2);
    }
}

캐시가 뭔지 물어보기
텍스트로 출력이되는ㄱ데 어떯데 충력된느
