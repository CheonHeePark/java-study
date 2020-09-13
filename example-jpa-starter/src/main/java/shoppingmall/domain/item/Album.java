package shoppingmall.domain.item;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/09/2020
 * Time : 12:10 AM
 */
@Builder
@Getter
@Entity
@DiscriminatorValue("ALBUM")
public class Album extends Item {
    private String artist;
    private String etc;
}
