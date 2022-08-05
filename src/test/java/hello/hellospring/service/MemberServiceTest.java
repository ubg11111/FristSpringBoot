package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 테스터가 실행하기전에 BeforEach가 각 생성자 함수를 만들어 변수에 넣어두고 사용
    // 직접 new 생성자함수를 만들어서 사용하는게 아닌 외부에서 의존성주입을 통해 사용하는것을 DI(Dependency Injection) 이라 함.
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    // AfterEach는 어떠한 메서드가 종료됨에따라 해당 메모리를 정리해준다.
    @AfterEach
    public void afterEach(){
        // MemoryMemberRepository안에 있는 clearStore() 메서드를 호출
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Spring");


        // when
        Long saveId =  memberService.join(member);


        // then
        Member findMember =  memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        // 두 결과값이 Spring 이므로 중복 확인됨.
        // validateDuplicateMember(member); 함수로 인해 중복 예외가 발생함.
        memberService.join(member1);

        // asserThrows를 던져서 class가 확인되면 람다식 () -> memberService에서 join(member2)가 같은것으로 확인되면 예외처리
        assertThrows(Exception.class, () -> memberService.join(member2));


/*try, catch 문으로 처리하는 경우
       try{
           memberService.join(member1);
           fail();
        }catch (IllegalStateException e){
           Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
       }
*/

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}