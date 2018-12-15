package io.github.dunwu.springboot.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* io.github.dunwu.springboot..*Service.*(..))")
    public void execute() {}

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        logger.warn("call @Before, joinPoint: {}", joinPoint);
    }

    // @Around("execute()")
    // public void around(JoinPoint joinPoint) {
    // logger.warn("call @Around, joinPoint: {}", joinPoint);
    // }

    @After("execute()")
    public void after(JoinPoint joinPoint) {
        logger.warn("call @After, joinPoint: {}", joinPoint);
    }

    @AfterReturning("execute()")
    public void afterReturning(JoinPoint joinPoint) {
        logger.warn("call @AfterReturning, joinPoint: {}", joinPoint);
    }

    @AfterThrowing("execute()")
    public void afterThrowing(JoinPoint joinPoint) {
        logger.error("call @AfterThrowing, joinPoint: {}", joinPoint);
    }
}
