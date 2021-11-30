package siru.spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import siru.spring.member.Grade;
import siru.spring.member.Member;
import siru.spring.member.MemberService;
import siru.spring.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void OrderServiceTest() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
