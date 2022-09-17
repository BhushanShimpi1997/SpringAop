package com.aop.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class BalanceCheckAspect {
	
	private Logger logger=Logger.getLogger(BalanceCheckAspect.class.getName());

	@Before("execution(* com.aop.services.MyService.startPayment(..)) && args(balance,..)")
	public void balanceLog(JoinPoint jp,double balance) throws Throwable {
		if(balance <=0) {
			logger. info("You dont have Account balance ");
			throw new RuntimeException("Insufficient Balance");
		}
	}
}
