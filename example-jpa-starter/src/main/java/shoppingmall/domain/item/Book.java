package shoppingmall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/09/2020
 * Time : 12:11 AM
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("BOOK")
public class Book extends Item {
    private String author;
    private String isbn;
}
