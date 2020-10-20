package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 21/10/2020
 * Time : 6:01 AM
 */

/* 검색 조건
 */
@Setter
@Getter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
