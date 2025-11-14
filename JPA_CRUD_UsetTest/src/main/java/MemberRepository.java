import Testing.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long user_id){
        return em.find(User.class, user_id);
    }

    public List<User> findAll(){
        String jpql = "select u from User u";
        return em.createQuery(jpql, User.class)
                .getResultList();
    }

    public User findByUserName(String name){
        String jpql = "select u from User u where u.name = :name";
        return em.createQuery(jpql, User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
