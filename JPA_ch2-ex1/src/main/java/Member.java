import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
JPA(Java Persistence API)
@Entity
@Table
@Id
@Column
*/

@Entity // 해당 클래스를 DB와 매핑할것이라고 JPA에 선언
@Table(name = "member") // DB의 어떤 TABLE과 매핑 할것인지 설정 | 생략시 클래스 이름(Member)으로 매핑함
public class Member {

    @Id // 식변자 필드 지정(PK, RDB의 Primary Key에 해당하는 속성과 매핑)
    @Column(name = "ID") // 필드는 DB의 컬럼에 매핑 (DB의 속성명과 매핑)
    private String id;

    @Column(name = "NAME")
    private  String username;

    // @Colum(name = "AGE")
    // Colum 어노테이션을 생략하면 필드명으로 속성을 매핑함
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
