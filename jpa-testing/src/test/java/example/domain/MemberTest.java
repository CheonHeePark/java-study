package example.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 20/10/2020
 * Time : 6:48 AM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void jpa_save_테스트(){
        Member member = new Member();
        member.setName("Chpark");
        member.setAge(34);
        // 비영속 -> 영속
        Member savedMember = memberRepository.save(member);

        // 영속화 후 반환값과 파라미터값 비교
        Assert.assertEquals(member, savedMember);
        Assert.assertTrue(entityManager.contains(member));

        Member newMember = new Member();
        newMember.setId(member.getId());
        // 준영속 -> 영속
        Member modifiedMember = memberRepository.save(newMember);

        // ID 비교
        Assert.assertEquals(savedMember.getId(), modifiedMember.getId());

        // 영속화 후 반환값과 파라미터값 비교
        Assert.assertNotEquals(newMember, modifiedMember);
        Assert.assertFalse(entityManager.contains(newMember));
    }
}
