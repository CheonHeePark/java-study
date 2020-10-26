package shoppingmall.domain;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.domain.Specification;
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
    // Containing을 사용하면 JPQL없이 JPA가 자동으로 Like검색 쿼리를 만들어준다.
    @Query("SELECT o, m FROM Order o INNER JOIN o.member m WHERE m.name like %:memberName% and o.status = :status")
    List<Order> findByMemberNameLikeAndStatus(String memberName, OrderStatus status);

    // Spec 사용
    List<Order> findAll(Specification<Order> orderSpecification);
}
