import jakarta.persistence.*;

// Post 엔티티
@Entity
public class Post {

    public Post(){};

    // 마찬가지로 ID 자동 생성, User는 연관관계를 맺으르모 생성자 x
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;

    /* 여기서 Post는 User를 가지는 이유
     Post 즉 개념적 설계에서
     유저는 게시물을 가지기 때문에 데이터베이스에서는 User의 FK를 가짐.
     자바에서는 객체는 User 객체를 참조함 즉 연관관계의 주인이 됨
     유저는 게시물을 여러개 생성하므로 User는 1 Post는 N 이 됨.
    */
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column(name = "USER_ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
