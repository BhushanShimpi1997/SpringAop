package com.aop.aspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

	private Logger log = Logger.getLogger(LoggerAspect.class.getName());

	@Around("execution(* com.aop.services.MyService.makePayment(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info(joinPoint.getSignature().toString() + "Method excution started");
		Instant start = Instant.now();

		joinPoint.proceed();
		Instant end = Instant.now();
		long timeElapsed = Duration.between(start, end).toMillis();
		log.info("Time taken by method to execute: " + timeElapsed);
		log.info(joinPoint.getSignature().toString() + " method Execution has end");
	}

	@AfterThrowing(value = "execution(* com.aop.services.MyService.initiatePayment(..))", throwing = "ex")
	public void logException(JoinPoint jp, Exception ex) {
		log.log(Level.SEVERE, jp.getSignature().toString() + "An Exceptio is thrown with the help of"
				+ "@AfterThrowing which happend due to: " + ex.getMessage());
	}

	@AfterReturning(value = "execution(* com.aop.services.MyService.initiatePayment(..))", returning = "retValue")
	public void logStatus(JoinPoint jp, Object retValue) {
		log.log(Level.INFO, jp.getSignature().toString() + " Method execution sucess with returing Value: " + retValue);
	}
	
	@After("@annotation(com.aop.interfaces.LogAspect)")
	public void logWithAnnotationStyle(JoinPoint jp) throws Throwable {
		log.log(Level.INFO, jp.getSignature().toString()+" This log is comming with @LogAspect Annotation ");
	}

}
