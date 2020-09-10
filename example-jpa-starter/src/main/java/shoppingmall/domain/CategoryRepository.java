package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 1:41 AM
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
