package shoppingmall;

import javax.persistence.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 2:15 AM
 */
// 상품
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;
}
