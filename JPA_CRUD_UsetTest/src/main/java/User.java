import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "USER")
public class User {

    protected User(){};

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "AGE")
    private String age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {

        // Team 초기화 -> null
        if (this.team != null) {
            this.team.getUsers().remove(this);
        }

        // User Join Team
        this.team = team;

        // Team join User
        if (team != null) {
            team.getUsers().add(this);
        }
    }
}
