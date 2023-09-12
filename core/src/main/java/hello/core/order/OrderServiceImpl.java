package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.fixRateDiscount;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService{
    MemberRepository memberRepository =  new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new fixRateDiscount();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountAmount = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountAmount);
    }
}
