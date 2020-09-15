package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;
import shoppingmall.domain.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 1:18 AM
 */
// 카테고리
@Setter
@Getter
@Entity
@Table(name = "CATEGORYS")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "CATEGORY_ITEMS",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    // 여러 상품들이 1개의 카테고리에 포함될 수 있고, 1개의 상품은 여러 카테고리를 가질 수 있으므로 N:M관계로 됨.
    private List<Item> items = new ArrayList<>();

    // 부모 카테고리 (여러 자식 카테고리들은 1개의 부모카테고리로 매핑되므로 N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    // 자식 카테고리 (현재 카테고리 하나가 여러 자식을 가질 수 있으므로 1:N)
    @OneToMany(mappedBy = "parent")
    private List<Category> childs = new ArrayList<>();

    // 자식 카테고리 추가
    public void addChildCategory(Category child) {
       childs.add(child);
       child.setParent(this);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private void setParent(Category parent) {
        this.parent = parent;
    }
}
