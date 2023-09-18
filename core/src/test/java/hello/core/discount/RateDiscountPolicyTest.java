package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10% 할인이 되어야한다")
    void vip_o(){
        Member userA = new Member(1L, "userA", Grade.VIP);

        int discountAmount = discountPolicy.discount(userA,20000);

        Assertions.assertThat(discountAmount).isEqualTo(2000);
    }

    // TEST는 실패하는 경우도 짜는게 좋다.
    @Test
    @DisplayName("VIP가 아닌경우는 할인이 되지 않아야한다.")
    void vip_x(){
        Member userB = new Member(1L, "userA", Grade.BASIC);

        int discountAmount = discountPolicy.discount(userB,10000);

        Assertions.assertThat(discountAmount).isZero();
    }
}