package io.github.dunwu.springboot.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@After("execute()")
	public void after(JoinPoint joinPoint) {
		log.info("call @After, joinPoint: " + joinPoint);
	}

	@AfterReturning("execute()")
	public void afterReturning(JoinPoint joinPoint) {
		log.info("call @AfterReturning, joinPoint: " + joinPoint);
	}

	// @Around("execute()")
	// public void around(JoinPoint joinPoint) {
	// log.info("call @Around, joinPoint: " + joinPoint);
	// }

	@AfterThrowing("execute()")
	public void afterThrowing(JoinPoint joinPoint) {
		System.err.println("call @AfterThrowing, joinPoint: " + joinPoint);
	}

	@Before("execute()")
	public void before(JoinPoint joinPoint) {
		log.info("call @Before, joinPoint: " + joinPoint);
	}

	@Pointcut("execution(* io.github.dunwu.springboot..*Service.*(..))")
	public void execute() {
	}

}
