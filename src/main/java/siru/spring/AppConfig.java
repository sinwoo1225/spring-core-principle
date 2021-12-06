package siru.spring;

import org.springframework.core.annotation.Order;
import siru.spring.discount.DiscountPolicy;
import siru.spring.discount.FixDiscountPolicy;
import siru.spring.member.MemberRepository;
import siru.spring.member.MemberService;
import siru.spring.member.MemberServiceImpl;
import siru.spring.member.MemoryMemberRepository;
import siru.spring.order.OrderService;
import siru.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }


}
