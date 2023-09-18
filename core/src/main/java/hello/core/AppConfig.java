package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.discount.fixRateDiscount;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceimpl(memberRepository());
    }
    //역할 - 구현이 잘 나눠짐.
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
}
