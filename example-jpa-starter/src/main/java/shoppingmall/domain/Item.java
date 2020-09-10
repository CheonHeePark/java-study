package shoppingmall.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:15 AM
 */
// 상품
@Getter
@Builder
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ITEM_ID")
    private Long id;

    private String name;            // 상품 이름

    private int price;              // 상품 가격

    private int stockQuantity;      // 재고 수량

    // 상품에서 주문상품을 참조할 일이 거의 없으므로, OrderItem -> Item 관계는 단방향1개로만 결정짓게된다.

    @ManyToMany(mappedBy = "items")
    private List<Category> categorys = new ArrayList<>();
}
