package shoppingmall.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 2:09 AM
 */
/* QueryDSL을 사용하기위해서는 QuerydslPredicateExecutor or QuerydslRepositorySupport 인터페이스를 확장해야 한다.
 * QuerydslPredicateExecutor를 확장하면 QueryDSL을 편리하게 사용할 수는 있지만, 기능에 한계가 있다. (join, fetch 사용 불가)
 * 다양한 기능을 사용하려면 JPAQuery를 사용하거나 QuerydslRepositorySupport 인터페이스를 확장한다.
 */
//public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
public interface ItemRepository extends JpaRepository<Item, Long> {
}
