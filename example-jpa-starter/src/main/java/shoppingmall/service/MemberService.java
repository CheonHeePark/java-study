package shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.Member;
import shoppingmall.domain.MemberRepository;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/10/2020
 * Time : 12:11 AM
 */

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param member 추가할 회원
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     * @return 가입된 전체 회원
     */
    @Transactional
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 단일 회원 조회
     * @param memberId 조회할 회원아이디
     * @return 회원
     */
    @Transactional
    public Member find(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("Wrong memberId: <" + memberId + ">"));
    }

    /* 회원 중복가입 체크
     */
    private void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findByName(member.getName());
        if (members == null || !members.isEmpty()) {
            throw new IllegalStateException("Already is exist member: <" + member.getName() + ">");
        }
    }
}
