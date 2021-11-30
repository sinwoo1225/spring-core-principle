package siru.spring;

import siru.spring.member.Grade;
import siru.spring.member.Member;
import siru.spring.member.MemberService;
import siru.spring.member.MemberServiceImpl;
import siru.spring.order.Order;
import siru.spring.order.OrderService;
import siru.spring.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calculatePrice());
    }
}
