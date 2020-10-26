package shoppingmall;

import shoppingmall.domain.Order;
import shoppingmall.domain.OrderSearch;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 27/10/2020
 * Time : 12:49 AM
 */

public interface CustomOrderRepository {
    List<Order> search(OrderSearch orderSearch);
}
