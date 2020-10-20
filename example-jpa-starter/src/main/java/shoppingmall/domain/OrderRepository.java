package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 07/09/2020
 * Time : 11:56 PM
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o, m FROM Order o INNER JOIN o.member m WHERE m.name like %:memberName% ")
    List<Order> findByMemberNameLike(String memberName);

    // TODO JPQL을 주석처리하면 검색결과 아무것도 조회되지않음. JPQL 조건 관련 확인해야함
    @Query("SELECT o, m FROM Order o INNER JOIN o.member m WHERE m.name like %:memberName% and o.status = :status")
    List<Order> findByMemberNameLikeAndStatus(String memberName, OrderStatus status);
}
