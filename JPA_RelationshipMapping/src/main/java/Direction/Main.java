package Direction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    //main Method
    public static void main(String[] args) {
        /*
        // 객체 그래프 탐색
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team = new Team("team1", "팀1");

        member1.setTeam(team);
        member2.setTeam(team);

        System.out.println(member1.getTeam().getId());
        System.out.println(member1.getTeam().getName());

        System.out.println(member2.getTeam().getId());
        System.out.println(member2.getTeam().getName());
        */
        //============================================================

        // CRUD
        RelationShip_CRUD crud = new RelationShip_CRUD();

        crud.testSave(); // persist()



    }


}
