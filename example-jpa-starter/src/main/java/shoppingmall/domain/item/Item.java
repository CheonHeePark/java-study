package shoppingmall.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingmall.domain.Category;
import shoppingmall.exception.NotEnoughStockException;

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
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "ITEMS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)       // 단일 테이블전략. 추후 조인전략으로 변경해보기
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ITEM_ID")
    private Long id;

    private String name;            // 상품 이름

    private int price;              // 상품 가격

    private int stockQuantity;      // 재고 수량

    // 상품에서 주문상품을 참조할 일이 거의 없으므로, OrderItem -> Item 관계는 단방향1개로만 결정짓게된다.

    @ManyToMany(mappedBy = "items")
    private List<Category> categorys = new ArrayList<>();

    /**
     * 재고 추가
     * @param quantity 추가할 재고량
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 감소
     * @param quantity 제거할 재고량
     */
    public void removeStock(int quantity) {
        if (this.stockQuantity < quantity) {
            throw new NotEnoughStockException("need more stock.");
        }
        this.stockQuantity -= quantity;
    }
}
