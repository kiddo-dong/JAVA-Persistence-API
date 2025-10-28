package Direction;

import jakarta.persistence.*;

import java.util.List;

public class RelationShip_CRUD {

    // JPA 사용 및 영속성 컨텍스트(1차캐시, SQL 저장소, EntityEntry) 사용
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    // 연관 관계 매핑
    // CRUD Method (JPA & Persistence context)

    // persist() | Create
    public void testSave() {

        Team team1 = new Team("team2", "팀2");

        Member member1 = new Member("member3", "도동동1");
        member1.setTeam(team1);

        Member member2 = new Member("member4", "도동2");
        member2.setTeam(team1);

        try {
            tx.begin();

            em.persist(team1); //
            em.persist(member1);
            em.persist(member2);

            tx.commit();
        } catch (NoResultException e) {
            tx.rollback();
        }
    }

    // find() | Read
    public void queryLogicJoin(){
        // Member 객체를 이용해서 Team 객체의 테이블 호출
        String jpql = "select m from Member m join m.team t " +
                "WHERE t.name = :teamName";

        // 1팀의 멤버 목록
        List<Member> memberList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        // getter() 호출시 DB에 쿼리 날림(쓰기 지연 SQL 저장소)
        for(Member m : memberList){
            System.out.println(m.getTeam().getName()+"의 멤버들 : " + m.getUsername());
        }
        System.out.println();

        Member member = em.find(Member.class, "member3");
        System.out.println(member.getUsername() + "의 팀 : " + member.getTeam().getName());
        System.out.println();
    }

    // setter() | Update
    public void update(){
        try {
            tx.begin();

            Team team1 = em.find(Team.class,"team1");

            // 팀2에 존재하는 도동2를 팀1 로 수정
            Member member = em.find(Member.class, "member4");

            System.out.println("도동2의 이전 팀 : " + member.getTeam().getName());

            // setter로 team1로 팀변경 (FK 인스턴스 변경)
            member.setTeam(team1);

            tx.commit();

            System.out.println("도동2의 새 팀 : "  + member.getTeam().getName());

        }catch (NoResultException e){
            tx.rollback();
        }
    }

    // remove() | Delete
    public void delete(){
        // MEMBER_ID : member2(회원2)
        // 를 제거 해보자

        try{
            tx.begin();
            // 1차 캐시 등록
            Member member = em.find(Member.class,"member2");

            // 엔티티 삭제(DB, 1차 캐시)
            member.setTeam(null); // 연관관계 제거
            em.remove(member); // 데이터 삭제

            tx.commit();
        } catch (NoResultException e){
            tx.rollback();
        }
    }

    public void biDirection(){
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for(Member member : members) {
            System.out.println("members : " + member.getUsername());
        }
    }

}
