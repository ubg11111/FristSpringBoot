package hello.hellospring;


import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    // Configuration을 통해서 클래스를 설정해주고, Bean 어노테이션을 생성하여 직접 관리하는 구조.

    @Bean
    public MemberService memberService(){
        // MemberService에 MemberRepository의 Bean을 매개변수로 주입.
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }



}
