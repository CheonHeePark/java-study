package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 21/10/2020
 * Time : 6:01 AM
 */

/* 검색 조건
 */
@Setter
@Getter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;

    public Specification<Order> toSpecification() {
        return Specification
                .where(OrderSpec.memberNameLike(memberName))
                .and(OrderSpec.orderStatusEqual(orderStatus));
    }
}
