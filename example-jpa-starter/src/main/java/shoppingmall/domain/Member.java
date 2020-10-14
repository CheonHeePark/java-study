package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 1:58 AM
 */

// 회원
@Setter
@Getter
@Entity
@Table(name = "MEMBERS")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")                 // Many쪽이 주인이므로, mappedBy에 주인 객체에서 FK로 사용중인 필드명을 설정한다.
    /**
     * TODO Lombok으로 Builder적용하면, orders 즉시생성이 불가함. 일단 setter사용하는 방식으로 변경했으나, 추후 변경필요
     * setter를 사용하면 불변객체를 사용하지못하므로 지양해야함.
     */
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
}
