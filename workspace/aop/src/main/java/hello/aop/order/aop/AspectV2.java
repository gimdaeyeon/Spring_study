package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV2 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder(){}// pointcut signature (메서드 이름과 파라미터를 합쳐서 포인트컷 시그니처라 한다.)

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[log] {}",joinPoint.getSignature()); // join point 시그니처
        return joinPoint.proceed();
    }
}
