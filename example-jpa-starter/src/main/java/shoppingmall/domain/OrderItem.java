package shoppingmall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingmall.domain.item.Item;

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
@NoArgsConstructor
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
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

    /**
     * 주문
     * @param item 주문 상품
     * @param orderPrice 주문 가격
     * @param count 주문 수량
     * @return
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
       OrderItem orderItem = new OrderItem();
       orderItem.setItem(item);
       orderItem.setOrderPrice(orderPrice);
       orderItem.setCount(count);
       // 주문한 만큼 재고 감소
       item.removeStock(count);
       return orderItem;
    }

    /**
     * 주문 취소
     */
    void cancel() {
        // 주문 취소되었으므로 재고 원복
        getItem().addStock(this.count);
    }

    /**
     * 주문 상품의 전체 가격
     * @return
     */
    int getTotalPrice() {
        return this.orderPrice * this.count;
    }
}
