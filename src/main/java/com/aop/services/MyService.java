package com.aop.services;

import org.springframework.stereotype.Service;

import com.aop.interfaces.LogAspect;

@Service
public class MyService {

	public void makePayment() {

		System.out.println("1000Rs." + "debited from account");

		System.out.println("1000Rs." + "Credited into account");
	}

	public void startPayment(double balance) {

		System.out.println("Starting payment...");
	}

	public String initiatePayment() {

	//	throw new NullPointerException("Damn! null pointer Exception Occured.!!");
		
		return "Payment Initiated Successfully...!!";

	}

	@LogAspect
	public void checkPayment() {
		
		System.out.println("payment is validated...");
		
	}
}
