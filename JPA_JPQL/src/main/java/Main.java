import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        
        // 엔티티 매니저 및 영속성 컨텍스트 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션으로 데이터 보호
        try{
            tx.begin();
            /*
            Team team = new Team("team11");

            Member member = new Member("dh", 24);
            member.setTeam(team);

            team.add(member);

            em.persist(team);
            em.persist(member);
            // 1차 캐시에 싹다 올라옴
             */

            /*
            //JPQL
            String jpql = "select m from Member as m where m.id = :id";
            // SQL : SELECT * FROM MEMBER WHERE ID = ?
            Member getMember = em.createQuery(jpql, Member.class)
                    .setParameter("id", 1L)
                    .getSingleResult();

            System.out.println("ID : " + getMember.getId() + " | NAME : " + getMember.getUsername() + " | AGE : " + getMember.getAge() + " | TEAM :" + getMember.getTeam().getName());
            */

            /*
            // JPQL 사용시 파라미터 바인딩 방식
            // 이름 기준 파라미터 바인딩
            // 위와 동일
            // 위치 기준 파라미터 바안딩
            String jpql2 = "select m from Member as m where m.id = ?1";
            Member getMember2 = em.createQuery(jpql, Member.class)
                            .setParameter(1, 1L).getSingleResult();
            */
            /*
            String jpql = "select m.username from Member m where m.id = :id";
            String memberName = em.createQuery(jpql, String.class)
                    .setParameter("id", 1L)
                    .getSingleResult(); // 한 개 결과를 가져올 때 사용
            System.out.println("MemberName : " + memberName);
            */
            /*
            String jpql = "select new MemberDTO(m.username, m.age, m.team.name) from Member m where m.id = :id";
            MemberDTO memberDTO = em.createQuery(jpql, MemberDTO.class)
                            .setParameter("id", 1L)
                            .getSingleResult();

            System.out.println("MemberDTO name : " + memberDTO.getUsername() + " | age : " + memberDTO.getAge() + " | teamName : " + memberDTO.getTeam());
            */

            /*
            String jpql = "select COUNT(m) from Member m where m.id = :id";
            Long memberCount = em.createQuery(jpql, Long.class)
                            .setParameter("id", 1L)
                            .getSingleResult();

            System.out.println("Member Count : "  + memberCount);
            */

            /*
            String jqpl = "delete from Member m where m.id = :id";
            em.createQuery(jqpl)
                            .setParameter("id", 1L)
                            .executeUpdate();
            */


            tx.commit(); // DB 저장
        }catch (NoResultException e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
