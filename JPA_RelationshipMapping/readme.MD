<h2>Relationship Mapping(연관관계 Mapping)</h2>
- 객체 간 관계를 JPA가 DB의 외래키(FK)와 연결하여 관리할 수 있도록 하는 것
<h3>- 연관 관계 정의 핵심 3가지</h3>
- 방향 (단방향, 양방향) | DB(테이터 중심) 와 객체 지향 패러다임 불일치</br>
  - DB에서는 JOIN으로 양방향 참조 가능</br>
  - 객체 지향에서는 필드로 다른 객체 참조</br>
    - 단방향 : A객체 에서 B객체(@Id) 참조</br>
    - 양방향 : A객체 B객체가 서로의 @Id(PK) 참조. 즉, 단방향 참조가 2개로 이루어짐.</br>
- 다중성 (관계의 형태 1:1, 1:N, N:1, N:N)</br>
  - 1:1(한 Entity - 한 Entity) : @OneToOne</br>
  - 1:N(한 Entity - 여러 Entity) : @OneToMany</br>
  - N:1(여러 Entity - 한 Entity) : @ManyToOne</br>
  - N:N(여러 Entity - 여러 Entity) : @ManyToMany</br>
- 연관 관계의 주인</br>
  - 두 객체가 양방향 관계</br>
  - 즉, A->B, B->A 일때(단방향 2개) 연관관계의 주인을 정해야함.</br>
  - 주인으로 지정된 객체가 외래키(FK)를 관리(DB의 등록/수정)</br>
  - 주인이 아닌 객체는 읽기만 할 수 있음</br>
  - 연관 관계의 주인은 @JoinColumn 어노테이션을 붙여줌.</br>
