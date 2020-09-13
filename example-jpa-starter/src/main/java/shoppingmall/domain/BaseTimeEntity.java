package shoppingmall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/09/2020
 * Time : 12:14 AM
 */
@NoArgsConstructor
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;           // 등록일
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;      // 수정일
}
