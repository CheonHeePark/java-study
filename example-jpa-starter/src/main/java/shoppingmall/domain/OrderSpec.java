package shoppingmall.domain;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 26/10/2020
 * Time : 11:09 PM
 */

class OrderSpec {
    static Specification<Order> memberNameLike(final String memberName) {
        return (Specification<Order>) (root, query, criteriaBuilder) -> {
            if (StringUtils.isEmpty(memberName)) {
                return null;
            }
            // memberName이 존재할 경우, Order Entity로부터 조인으로 연결된 Member Entity를 가져온다.
            Join<Order, Member> m = root.join("member", JoinType.INNER);
            // Member Entity의 name을 가져와서 like 조건문으로 만든다.
            return criteriaBuilder.like(m.get("name"), "%" + memberName + "%");
        };
    }

    static Specification<Order> orderStatusEqual(final OrderStatus orderStatus) {
        return (Specification<Order>) (root, query, criteriaBuilder) -> {
            if (orderStatus == null) {
                return null;
            }
            // orderStatusrㅏ 존재할 경우, orderStatus와 Order Entity에 저장된 status를 비교하여 일치할 경우 true 반환한다.
            return criteriaBuilder.equal(root.get("status"), orderStatus);
        };
    }
}
