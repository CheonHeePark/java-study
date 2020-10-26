package shoppingmall.domain;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import shoppingmall.CustomOrderRepository;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 27/10/2020
 * Time : 12:46 AM
 */

/* QueryDSL을 사용하기 위한 예제
 * TODO. SpringDataJPA가 제공하는 공통 인터페이스는 직접 구현할 수 없어 CusotmOrderRepository와 같은 사용자정의 인터페이스를 만들어 구현한다.?
 */
@Repository
public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {
    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> search(OrderSearch orderSearch) {
        QOrder order = QOrder.order;
        QMember member = QMember.member;
        JPQLQuery query = from(order);
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.leftJoin(order.member, member)
                    .where(member.name.contains(orderSearch.getMemberName()));
        }

        if (orderSearch.getOrderStatus() != null) {
            query.where(order.status.eq(orderSearch.getOrderStatus()));
        }

        return query.fetch();
    }
}
