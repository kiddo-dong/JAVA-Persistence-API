package members;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
// @Table(name = "MEMBER")
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Member {

    @Id
    /* DB에 PK 생성 위임 후 1차 캐시에서 PK값 리턴 받아옴
       즉, DB 선 저장 -> 엔티티 후 할당
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       시퀀스 식별자를 엔티티에 넣어줌, 그 후 DB에 저장
       즉, 엔티티 선 할당 -> DB 후 저장
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    //@Column(name = "AGE")

    private Integer age;

    // 권한 설정 필드 (USER | ADMIN)
    // Java의 ENUM(상수)를 DB에 저장할 타입으로 지정 및 JPA에서 이용
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 생성 및 수정 시간
    // Java 날짜 타입 매핑
    /*
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    */
    
    // 자바 8 이후의 날짜 타입 매핑
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @Lob
    // DB의 CLOB, BLOB 타입과 매핑
    private String description;

    @PrePersist
    public void prePersist(){
        createdDate = LocalDateTime.now();
        lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        lastModifiedDate = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
