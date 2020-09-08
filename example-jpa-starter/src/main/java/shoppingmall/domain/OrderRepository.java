package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 07/09/2020
 * Time : 11:56 PM
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
