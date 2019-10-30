package com.chase.payment;

public class PaymentProcessor {
	public PaymentProcessor() {
		
	}
	
	public String ping() {
		return ("The bank is up and running");
	}
	
	public String processPayment(CreditCardPayment payment) {
		return("1234-5678");
		
	}

}
