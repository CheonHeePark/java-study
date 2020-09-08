package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 07/09/2020
 * Time : 11:57 PM
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
}
