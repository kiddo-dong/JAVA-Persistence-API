package Direction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //해당 필드에서 객체 A의 id 참조(단방향)
    private A A_id;
    // A->B의 @Id 참조, B->A의 @Id 참조
    // 단방향 2개로 서로를 참조 중이므로
    // 양방향 참조.

    // Getter/Setter
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

    public A getA_id() {
        return A_id;
    }

    public void setA_id(A a_id) {
        A_id = a_id;
    }
}
