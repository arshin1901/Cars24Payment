package com.cars.mapper;

import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;

public class PaymentMapper {

		public static Payment toPayment(PaymentDto paymentdto) {
			Payment payment=new Payment();
			payment.setId(paymentdto.getId());
			payment.setPaymentId(paymentdto.getPaymentId());
			payment.setType(paymentdto.getType());
			payment.setStatus(paymentdto.getStatus());
			payment.setCard(paymentdto.getCard());
			/*customer.setDob(customerdto.getDob());
			customer.setAddress(customerdto.getAddress());
			customer.setEmail(customerdto.getEmail());*/
			return payment;
		}
		
		public static PaymentDto toPaymentDto(Payment payment) {
			PaymentDto paymentDto=new PaymentDto();
			paymentDto.setId(payment.getId());
			paymentDto.setPaymentId(payment.getPaymentId());
			paymentDto.setType(payment.getType());
			paymentDto.setStatus(payment.getStatus());
			paymentDto.setCard(payment.getCard());
			/*customer.setDob(customerdto.getDob());
			customer.setAddress(customerdto.getAddress());
			customer.setEmail(customerdto.getEmail());*/
			return paymentDto;
		}
		
	
}
