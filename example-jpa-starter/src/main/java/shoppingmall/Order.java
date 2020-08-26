package shoppingmall;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:06 AM
 */
// 주문
@Table(name = "ORDERS")
@Entity
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
}
