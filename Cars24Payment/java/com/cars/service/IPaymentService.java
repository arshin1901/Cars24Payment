package com.cars.service;

import java.util.List;

import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;

public interface IPaymentService {
	Payment addPayment(PaymentDto paymentdto);
	String removePayment(int id);
	Payment updatePayment(int id,PaymentDto paymentdto);
	Payment getPaymentDetails(int id);
	List <Payment>getAllPaymentDetails();
	
}
