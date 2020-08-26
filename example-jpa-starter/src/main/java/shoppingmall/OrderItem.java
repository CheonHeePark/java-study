package shoppingmall;

import javax.persistence.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:13 AM
 */
// 주문 상품 (주문과 상품의 N:M을 1:N, N:1의 형태로 매핑하기 위한 중간 매핑 엔티티 )
@Table(name = "ORDER_ITEM")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ITEM_ID")
    private Long itemId;

    private int orderPrice;

    private int count;
}
