package siru.spring.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import siru.spring.AppConfig;
import siru.spring.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    /**
     * 요청마다 계속해서 객체를 생성함 -> 메모리 낭비, GC 오버헤드 문제점
     * -> 싱글톤 적용하면 위의 문제점 해결 쌉가능
     */
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인 memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

    }
}
