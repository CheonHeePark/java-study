package shoppingmall;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 04/09/2020
 * Time : 1:58 AM
 */

// 회원
@Getter
@Entity
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;
}
