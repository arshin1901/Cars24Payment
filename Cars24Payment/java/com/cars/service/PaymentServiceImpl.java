package com.cars.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;
import com.cars.exception.IdNotFoundException;
import com.cars.exception.PaymentNotExistsException;
import com.cars.mapper.PaymentMapper;
//import com.cars.repository.IPaymentRepository;
import com.cars.repository.IPaymentRepository;

@Transactional
@Service("ps")
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	IPaymentRepository pr;
	Payment payment;
	@Override
	public Payment addPayment(PaymentDto paymentDto) { 
	
		Payment paymentobj=PaymentMapper.toPayment(paymentDto);
		return pr.save(paymentobj);
		
	}


	@Override
	public String removePayment(int id) {
		Optional<Payment> m= pr.findById(id); 
		if(m.isPresent())
		{
			pr.deleteById(id);
			return "REMOVE";
		}
		else 
		
		{
			throw new PaymentNotExistsException("Payment Not Exists");
		}
		
	}

	@Override
	public Payment updatePayment(int id,PaymentDto paymentDto) {
		
		Payment paymentobj=PaymentMapper.toPayment(paymentDto);
			return pr.save(paymentobj);
		}
	



	@Override
	public Payment getPaymentDetails(int id) {
		Optional<Payment> m= pr.findById(id); 
		if(m.isPresent()) {
			return m.get();
		}
		else {
			throw new IdNotFoundException("Id Not Found!!!!!!!");
		}
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> m = new ArrayList<Payment>();  
		pr.findAll().forEach(obj -> m.add(obj));  
		return m;
	}

}
