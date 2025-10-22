import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    //FK 이지만 DB 주도 개발로 지정
    private Long member_id;

    //@Temporal(TemporalType.DATE)
    private LocalDateTime order_date;

    // Enum 타입 테이블과 Mapping
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @PrePersist
    public void orderPersist(){
        order_date = LocalDateTime.now();
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
