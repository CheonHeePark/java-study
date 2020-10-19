package example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 20/10/2020
 * Time : 6:45 AM
 */

public interface MemberRepository extends JpaRepository<Member, Long> {
}
