package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 스프링 컨테이너가 생기고 @Controller라는 어노테이션이 있으면 컨테이너에 객체를 생성해서 넣어둠. (스프링이 관리)

    private final MemberService memberService;

    // Autowired는 필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입한다.
    // 생성자,setter,필드 에서 사용이 가능.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}


