package shoppingmall.domain;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 1:08 AM
 */
// 배송
@Getter
@Entity
@Table(name = "DELIVERYS")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    void setOrder(Order order) {
        this.order = order;
    }
}
