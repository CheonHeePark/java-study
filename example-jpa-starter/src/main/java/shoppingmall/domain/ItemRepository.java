package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 2:09 AM
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
