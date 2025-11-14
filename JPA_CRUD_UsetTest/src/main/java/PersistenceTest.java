import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersistenceTest {
    
    // Persistence Context로 컨테이너에 JPA의 엔티티 매니저 주입
    @PersistenceContext
    EntityManager em;


}
