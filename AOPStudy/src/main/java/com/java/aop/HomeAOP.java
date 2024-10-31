package com.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.java.dto.HomeDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class HomeAOP {
	
	@Pointcut("within(com.java.controller.HomeController)")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		log.info("before");
		Object[] objs = jp.getArgs();
		for(Object obj : objs) {
			log.info("파라미터 : ", obj);
			if(obj instanceof HomeDTO) {
				HomeDTO dto = (HomeDTO) obj;
				dto.setName("최유미");
			}
		}
	}
	
	@AfterReturning(pointcut="pointcut()", returning = "returnValue")
	public void aferReturning(JoinPoint jp, Object returnValue) {}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "exception")
	public void afterThrowing() {}
	
	@After("pointcut()")
	public void after(JoinPoint jp) {
		log.info("after");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		log.info("around");
		Object[] objs = jp.getArgs();
		for(Object obj : objs) {
			log.info("파라미터 : ", obj);
			if(obj instanceof HomeDTO) {
				HomeDTO dto = (HomeDTO) obj;
				dto.setName("최유미");
			}
		}
		return jp.proceed();
	}
}
