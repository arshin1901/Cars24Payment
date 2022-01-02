package com.cars.exception;

import com.cars.entities.Payment;

public class PaymentNotExistsException extends RuntimeException{
	public PaymentNotExistsException(String s)
	{
		super(s);
	}
	

}
