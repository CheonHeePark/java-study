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
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 1명의 회원은 N개의 주문을 가질수 있으므로, 주문이 FK를 갖게되어 주인이 된다.
    @JoinColumn(name = "MEMBER_ID")     // name => FK 컬럼명 (주인객체의 @Id에 매핑된 컬럼명)
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)      // 1개의 주문은 N개의 주문목록을 가질 수 있으므로, 주문목록이 FK를 갖는다.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   // 지연로딩 + 영속성전이
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;          // 배송 정보

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date orderDate;             // 주문 시간

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    public Order(Member orderer) {
        setOrderer(orderer);
    }

    // 주문목록 추가
    public void addOrderItem(OrderItem orderItem) {
       orderItems.add(orderItem);
       orderItem.setOrder(this);
    }

    // 배송지 정보 변경
    public void changeDeliveryInfo(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    private void setOrderer(Member member) {
       if (this.member != null) {
           this.member.getOrders().remove(this);
       }
       this.member = member;
       this.member.getOrders().add(this);
    }
}
