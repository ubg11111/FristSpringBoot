package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// aop 를 사용하기 위핸 Aspect 어노테이션 추가
@Aspect
@Component
public class TimeTraceAop {

    // Around를 어노테이션 문법으로 hello.hellospring..*(..) 모든 하위 패키지에 적용시키는 문법
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable{
        long start = System.currentTimeMillis();

        System.out.println("START " + joinPoint.toString());


        try{
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }

}
