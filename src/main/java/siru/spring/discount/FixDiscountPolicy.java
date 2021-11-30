package siru.spring.discount;

import siru.spring.member.Grade;
import siru.spring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static final int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }

}
