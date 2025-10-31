import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// User 엔티티
@Entity
@Table(name = "users")
public class User {

    public User(){};

    // Id는 자동생성, 게시물은 Setter로 연관관계를 맺으므로 생성자 X
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private int age;

    /* 리스트를 필드로 만드는 이유
       양방향 참조를 해주기 위해서
       개념적 설계에서 유저는 여러 게시물을 가지기 때문에 List로 참조해서 받아옴
       Post에서 해당 엔티티를 user로 참조중
    */
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post){
        posts.add(post);
        post.setUser(this); // post 엔티티의 객체에도 user넣어줌
    }

}
