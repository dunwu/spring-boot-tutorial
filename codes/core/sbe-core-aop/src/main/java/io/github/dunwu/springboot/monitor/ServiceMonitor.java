package io.github.dunwu.springboot.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

    @Pointcut("execution(* io.github.dunwu.springboot..*Service.*(..))")
    public void execute() {}

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        System.out.println("call @Before, joinPoint: " + joinPoint);
    }

    // @Around("execute()")
    // public void around(JoinPoint joinPoint) {
    //     System.out.println("call @Around, joinPoint: " + joinPoint);
    // }

    @After("execute()")
    public void after(JoinPoint joinPoint) {
        System.out.println("call @After, joinPoint: " + joinPoint);
    }

    @AfterReturning("execute()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("call @AfterReturning, joinPoint: " + joinPoint);
    }

    @AfterThrowing("execute()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.err.println("call @AfterThrowing, joinPoint: " + joinPoint);
    }
}
