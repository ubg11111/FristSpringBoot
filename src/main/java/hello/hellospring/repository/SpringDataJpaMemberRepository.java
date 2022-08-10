package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository {


    // select m from Member m where m.name = ? 형식으로 쿼리를 짜주게 됨.
    @Override
    Optional<Member> findByName(String name);


}
