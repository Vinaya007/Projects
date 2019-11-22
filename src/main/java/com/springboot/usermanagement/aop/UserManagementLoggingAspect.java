package com.springboot.usermanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.springboot.usermanagement.controller.UserManagementController;


@Aspect
@Component
public class UserManagementLoggingAspect {
	//setup logger
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	//setup point cut declarations
	
	//for controller package
	
	@Pointcut("execution(* com.springboot.usermanagement.controller.*.*(..))")
	private void forControllerPackage(){}
	
	//for Service package
	@Pointcut("execution(* com.springboot.usermanagement.service.*.*(..))")
	private void forServicePackage(){}
	
	//for DAO Package
	@Pointcut("execution(* com.springboot.usermanagement.dao.*.*(..))")
	private void forDaoPackage(){}
	
	// for application flow
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow(){}
	
	
	//ADD before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint){		
		String theMethod=joinPoint.getSignature().toShortString();
		logger.info("=======>@Before<===== : "+theMethod);			
		Object[] args=joinPoint.getArgs();		
		for(Object arg:args){
			logger.info("=======>The Arguments<===== : "+arg);
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void after(JoinPoint joinPoint, Object theResult){
		String theMethod=joinPoint.getSignature().toShortString();
		logger.info("=======>@After<===== : "+theMethod);		
		logger.info("=======>The Result<===== : "+theResult);		
	}
	
	@AfterThrowing(
			pointcut="forAppFlow()",
			throwing="ex")
	public void afterThrow(JoinPoint joinPoint,Exception ex){		
		String theMethod=joinPoint.getSignature().toShortString();
		logger.info("=======>@AfterThrow<===== : "+theMethod);			
			logger.info("=======>The Exception <===== : "+ex.getMessage());
	}
}
