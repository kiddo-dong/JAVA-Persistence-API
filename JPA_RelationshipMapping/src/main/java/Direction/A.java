package Direction;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class A {

    private Long id;
    private String name;

    //해당 필드에서 객체 B의 id 참조(단방향)
    private B B_id;

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

    public B getB_id() {
        return B_id;
    }

    public void setB_id(B b_id) {
        B_id = b_id;
    }
}
