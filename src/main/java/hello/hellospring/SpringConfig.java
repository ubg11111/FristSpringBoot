package hello.hellospring;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {


/*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }*/

    // Jpa사용을 위한 EntityManaget 컨스트럭 설정
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();

        // DB 레퍼지토리로 설정하기
        //return new JdbcMemberRepository(dataSource);


        // JdbcTemplate 리포지토리로 설정하기
       //return new JdbcTemplateMemberRepository(dataSource);


        // Jpa 리포지토리로 설정하기
        return new JpaMemberRepository(em);
    }
}