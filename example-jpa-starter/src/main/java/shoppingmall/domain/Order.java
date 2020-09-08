package shoppingmall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:06 AM
 */
// 주문
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne                          // 1명의 회원은 N개의 주문을 가질수 있으므로, 주문이 FK를 갖게되어 주인이 된다.
    @JoinColumn(name = "MEMBER_ID")     // name => FK 컬럼명 (주인객체의 @Id에 매핑된 컬럼명)
    private Member member;

    @OneToMany(mappedBy = "order")      // 1개의 주문은 N개의 주문목록을 가질 수 있으므로, 주문목록이 FK를 갖는다.
    private List<OrderItem> orderItems = new ArrayList<>();

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    public Order(Member orderer) {
        setOrderer(orderer);
    }

    public void addOrderItem(OrderItem orderItem) {
       orderItems.add(orderItem);
       orderItem.setOrder(this);
    }

    private void setOrderer(Member member) {
       if (this.member != null) {
           this.member.getOrders().remove(this);
       }
       this.member = member;
       this.member.getOrders().add(this);
    }
}