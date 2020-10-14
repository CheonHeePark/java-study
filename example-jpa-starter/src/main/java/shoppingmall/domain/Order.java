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

    /**
     * 상품 주문
     * @param member    주문요청한 회원
     * @param delivery  주문요청한 회원의 배송지
     * @param orderItems 주문요청된 상품 목록
     * @return 생성된 주문
     */
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setOrderer(member);
        order.changeDeliveryInfo(delivery);
        for (OrderItem orderItem: orderItems) {
           order.addOrderItem(orderItem);
        }
        order.changeStatus(OrderStatus.ORDER);
        return order;
    }

    /** 주문 취소
     */
    public void cancelOrder() {
        validDeliveryStatus();
        for (OrderItem orderItem: this.orderItems) {
            orderItem.cancel();
        }
        this.changeStatus(OrderStatus.CANCEL);
    }

    /**
     * 전체 주문가격 조회
     * @return
     */
    public int totalPrice() {
        int total = 0;
        for (OrderItem orderItem : this.orderItems) {
            total += orderItem.getTotalPrice();
        }
        return total;
    }

    /** 주문목록 추가
     * @param orderItem
     */
    public void addOrderItem(OrderItem orderItem) {
       this.orderItems.add(orderItem);
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

    private void changeStatus(OrderStatus status) {
        this.status = status;
    }

    private void validDeliveryStatus() {
        if (this.delivery.getStatus().equals(DeliveryStatus.COMPLETED)) {
            throw new RuntimeException("This order is completed(Delivery OK). so cannot order-cancel.");
        }
    }
}
