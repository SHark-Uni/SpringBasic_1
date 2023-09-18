package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class meberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService() ;
    @Test
    @DisplayName("회원가입을 테스트합니다")
    void join(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        //when
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(memberA).isEqualTo(findMember);

    }
}
