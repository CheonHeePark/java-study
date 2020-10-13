package shoppingmall.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.Member;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/10/2020
 * Time : 12:29 AM
 */

/*  TODO  Service & Repository만 단위테스트하려면 어떻게 해야하는지? 잘몰라서 일단 통합테스트로 진행함
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional      // 테스트 클래스에 @Transactional 붙여주면 매 테스트마다 트랜잭션 롤백되므로 테스트하기 좋음
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void 회원_가입_테스트() {
        Member member = new Member();
        member.setName("CheonHeePark");

        Long savedMemberId= memberService.join(member);

        Assert.assertEquals(savedMemberId, memberService.find(savedMemberId).getId());
    }

    // 중복 가입 예외가 발생하면 테스트 성공으로 간주한다.
    @Test(expected = IllegalStateException.class)
    public void 회원_중복가입_테스트() {
        Member member1 = new Member();
        member1.setName("chpark");

        Member member2 = new Member();
        member2.setName("chpark");

        memberService.join(member1);
        memberService.join(member2);

        Assert.fail("Failed join. becuase of duplicated member_name: <" + member1.getName() + ">");
    }

    @Test
    public void 회원_전체조회_테스트() {
        Member member1 = new Member();
        member1.setName("chpark");

        Member member2 = new Member();
        member2.setName("jmpark");

        Member member3 = new Member();
        member3.setName("sekim");

        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);

        Assert.assertEquals(3, memberService.findMembers().size());
    }
}
