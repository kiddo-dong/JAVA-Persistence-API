package Testing;

import jakarta.persistence.*;

import java.util.List;

public class Testing {
/*    public static void main(String[] args) {

        // EntityManager & Persistence Context (JPA)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            User user = em.find(User.class, 1);
            System.out.println(user.getId() + " | " + user.getName()+ " | "+ user.getAge());

            Team team = em.find(Team.class,1);
            System.out.println(team.getName());
            List<User> users = team.getUsers();
            // 전체 출력
            for(User u : users) {
                System.out.println(" |   " + u.getName() + "  | ");
            }

            String jpql = "select u from Testing.User u join u.team t where u.id = :id";


            User user1 = em.createQuery(jpql, User.class)
                    .setParameter("id", 1L)
                    .getSingleResult();
            System.out.println(user1.getId() + " | " + user1.getName()+ " | "+ user1.getAge());
            // 지연 로딩(현재 시점에서 team1에 Proxy참조)
            Testing.Team team1 = user1.getTeam();
            // 여기서 EM가 DB에 SELECT 쿼리 날림
            System.out.println(team1.getId() + " | "+team1.getName());

            System.out.println(user1.getName()); // 현상태 출력
            user1.setName("동현"); // 엔티티 인스턴스 변경
            em.flush(); // flush() 호출하는 순간 1차캐의 엔티티랑 영속성컨텍스트의 EntityEntry에 있는 스냅샷과 비교 후 entity의 인스턴스 변경감지 시 update 쿼리를 쓰기 지연 SQL에 만들어서 DB로 쿼리를 보냄
            System.out.println(user1.getName()); ; // 변경 확인

            jpql = "select u from Testing.User u where u.id = :id";
            User user2 = em.createQuery(jpql, User.class)
                    .setParameter("id", 2L)
                    .getSingleResult();

            em.remove(user2);

            tx.commit();
        } catch (NoResultException e){

        } finally {
            em.close();
        }
        emf.close();
    }*/
}