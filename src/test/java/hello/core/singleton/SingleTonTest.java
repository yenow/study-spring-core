package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        // 2. 조회
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른것을 확인
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        // memberService != memberService2
        assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // 2. 조회
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른것을 확인
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        // memberService != memberService2
        assertThat(memberService).isSameAs(memberService2);
    }
}