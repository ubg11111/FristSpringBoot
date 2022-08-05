package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // Test는 순서와 서로 관계없이 서로 의존관계없이 설계되어야 하는데.
    // 저장소를 깔끔하게 비워주워야 설계대로 데이터를 읽게 해야함.

    // AfterEach는 어떠한 메서드가 종료됨에따라 해당 메모리를 정리해준다.
    @AfterEach
    public void afterEach(){
        // MemoryMemberRepository안에 있는 clearStore() 메서드를 호출
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();

        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();

        member2.setName("spring2");
        repository.save(member2);


        Member result =  repository.findByName("spring1").get();


        Assertions.assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

        List<Member> result =  repository.findAll();


        Assertions.assertThat(result.size()).isEqualTo(2);
    }


}
