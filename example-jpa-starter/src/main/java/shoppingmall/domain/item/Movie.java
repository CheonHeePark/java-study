package shoppingmall.domain.item;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/09/2020
 * Time : 12:12 AM
 */
@Builder
@Getter
@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends Item {
    private String director;
    private String actor;
}
