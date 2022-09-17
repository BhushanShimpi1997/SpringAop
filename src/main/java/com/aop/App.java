package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.configuration.JavaConfig;
import com.aop.services.MyService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        MyService myService = context.getBean("myService", MyService.class);
       
        myService.checkPayment();
        
      //  myService.initiatePayment();
        
		/*
		 * double balance=1200; myService.startPayment(balance);
		 * myService.makePayment();
		 */
        
    }
}
