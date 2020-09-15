package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 16/09/2020
 * Time : 12:28 AM
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
