package Direction;

import jakarta.persistence.*;

// 순수한 객체 연관 관계 5.2 예제
// JPA를 사용해서 연관관계 매핑
@Entity
@Table(name = "member")
public class Member {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private String id;

    @Column(name = "USERNAME")
    private String username;

    // Team 객체 참조
    // 즉, Team의 참조를 보관하는 필드 객체
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
