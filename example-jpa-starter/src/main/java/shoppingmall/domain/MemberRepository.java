package shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 07/09/2020
 * Time : 11:57 PM
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    /* Like : excape-char가 자동으로 붙여지지 않는다. 개발자가 맞는 escape-char를 설정해야 한다.
     * Containing : escape-char가 기본으로 %로 붙여진다.
     */
    List<Member> findByNameLike(String name);

    List<Member> findByNameContaining(String name);
}
