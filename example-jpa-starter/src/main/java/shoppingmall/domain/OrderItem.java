package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:13 AM
 */
// 주문 상품 (주문과 상품의 N:M을 1:N, N:1의 형태로 매핑하기 위한 중간 매핑 엔티티 )
@Setter
@Getter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;

    private int count;

    public OrderItem(Order order, Item item) {
        this.order = order;
        this.item = item;
        this.orderPrice = item.getPrice();
        this.count = 1;
    }

    void setOrder(Order order) {
        this.order = order;
    }
}
