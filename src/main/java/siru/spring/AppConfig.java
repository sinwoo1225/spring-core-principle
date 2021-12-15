package siru.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import siru.spring.discount.DiscountPolicy;
import siru.spring.discount.RateDiscountPolicy;
import siru.spring.member.MemberRepository;
import siru.spring.member.MemberService;
import siru.spring.member.MemberServiceImpl;
import siru.spring.member.MemoryMemberRepository;
import siru.spring.order.OrderService;
import siru.spring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * 할인 정책을 바꿀떄 OrderServiceImpl을 변경할 필요없이 AppConfig만 변경하면 된다.
     *
     */
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
