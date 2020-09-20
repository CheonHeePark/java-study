package shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 21/09/2020
 * Time : 12:02 AM
 */
@Setter
@Getter
@Embeddable
public class Address {
    private String city;

    private String street;

    private String zipcode;
}
