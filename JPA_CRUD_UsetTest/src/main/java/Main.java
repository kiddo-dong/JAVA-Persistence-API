import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
            // DB에 쿼리 날림 및 Flush()
            tx.commit();
        } catch (NoResultException e){

        } finally {
            em.close();
        }
        emf.close();
    }
}