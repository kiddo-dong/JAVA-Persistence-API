package Direction;

import jakarta.persistence.*;

public class RelationShip_CRUD {

    // JPA 사용 및 영속성 컨텍스트(1차캐시, SQL 저장소, EntityEntry) 사용
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    // 연관 관계 매핑
    // CRUD Method (JPA & Persistence context)

    // persist()
    public void testSave(){

        Team team1 = new Team("team", "팀1");

        try {
            tx.begin();

            em.persist(team1);

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1); // Member의 필드에 team1인스턴스 주입
        try {
            tx.begin();

            em.persist(member1);

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        try {
            tx.begin();

            em.persist(member2);

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }

        em.close();
        emf.close();
    }


    //
}
