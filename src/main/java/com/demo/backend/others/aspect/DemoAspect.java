package com.demo.backend.others.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	private final static Logger log = LoggerFactory.getLogger(DemoAspect.class);

	@Pointcut("execution(* com.demo.backend.aop.*.*(..))")
	private void doit() {
	}

	@Before("doit()")
	public void beforeAdvice() {
		log.info("Point break !!!");
		log.info("Point break !!!");
		log.info("Point break !!!");
	}

	@Around("doit()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("logAround() is running!");
		return joinPoint.proceed();
	}
}
