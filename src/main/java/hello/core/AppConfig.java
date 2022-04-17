package hello.core;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 역할이 잘 드러나는 명칭, 역할과 구현클래스가 한눈에 들어온다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() { return new MemoryMemberRepository(); }

    public OrderService orderService() { return new OrderServiceImpl(memberRepository(), disCountPolicy()); }

    public DisCountPolicy disCountPolicy() { return new RateDiscountPolicy(); }  // FixDiscountPolicy
}
