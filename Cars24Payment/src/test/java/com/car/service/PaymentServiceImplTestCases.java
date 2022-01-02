package com.car.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;
import com.cars.exception.IdNotFoundException;
import com.cars.mapper.PaymentMapper;
import com.cars.repository.IPaymentRepository;
import com.cars.service.PaymentServiceImpl;


	public class PaymentServiceImplTestCases {

		@InjectMocks
		PaymentServiceImpl paymentservice;
		@Mock
		IPaymentRepository paymentRepository;
		@Mock
		PaymentDto paymentdto;
		@Mock
		 Payment payment;
		
		
		@BeforeEach
		void startup() {
			MockitoAnnotations.initMocks(this);
			//customer.setName("maya");
			//customer.setId(101);
			//customer.setContactNo("456576879");
			 payment=new  Payment(12,1,"Cash","Succeed",null);
			 paymentdto=new PaymentDto(12,1,"Cash","Succeed",null);
			/*
			 * customerdto.setName("rokey"); customerdto.setContactNo("6785746543");
			 * customerdto.setId(102); customerdto.setEmail("rokey@gmail.com");
			 */
		}
		
		@Test
		void testPaymentById() {										//customer by id
			when(paymentRepository.findById(101)).thenReturn(Optional.of(payment));
			assertEquals(payment,paymentservice.getPaymentDetails(101));
			Mockito.verify(paymentRepository,times(1)).findById(101);
		}
		
		@Test
		void testPaymentByIdNotFound() {    							//customer by id -ve test
			when(paymentRepository.findById(101)).thenReturn(Optional.ofNullable(null));
			assertThrows(IdNotFoundException.class,()->paymentservice.getPaymentDetails(101));
			Mockito.verify(paymentRepository,times(1)).findById(101);
		}
		
		
		  @Test public void testaddPayment() { //add customer
		  Mockito.when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
		  PaymentDto paymentdto1=PaymentMapper.toPaymentDto(payment);
		  Payment paymentdto2=paymentservice.addPayment(paymentdto1);
		  assertEquals(paymentdto1.getId(),paymentdto2.getId());
		  Mockito.verify(paymentRepository,times(1)).save(any(Payment.class));
		  }
		 
		
		@Test
		public void testGetAllPayment() {			//get all customer
			Mockito.when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment));
			assertEquals(Arrays.asList(payment),paymentservice.getAllPaymentDetails());
			Mockito.verify(paymentRepository,times(1)).findAll();
		}
		
		
		@Test
		public void deletePaymentById() {
			when(paymentRepository.findById(12)).thenReturn(Optional.of(payment));
			assertEquals("REMOVE",paymentservice.removePayment(12));
			Mockito.verify(paymentRepository,times(1)).deleteById(12);
		}
		
		
		/*@Test public void testUpdatePayment() { //add customer
			  Mockito.when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
			  PaymentDto paymentdto1=PaymentMapper.toPaymentDto(payment);
			  Payment paymentdto2=paymentservice.updatePayment(12,paymentdto1);
			  assertEquals(paymentdto1.getPaymentId(),paymentdto2.getPaymentId());
			  Mockito.verify(paymentRepository,times(1)).save(any(Payment.class));
			  }*/
		
		
		
		@Test public void testUpdatePayment() { //add customer
			  Mockito.when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
			  PaymentDto paymentdto1=PaymentMapper.toPaymentDto(payment);
			  Payment paymentdto2=paymentservice.updatePayment(12,paymentdto1);
			  assertEquals(paymentdto1.getPaymentId(),paymentdto2.getPaymentId());
			  Mockito.verify(paymentRepository,times(1)).save(any(Payment.class));
			  }
	}

	































/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cars.entities.Card;
import com.cars.entities.Payment;
import com.cars.service.IPaymentService;

public class PaymentServiceImplTestCases {
	@Autowired
	private IPaymentService ps;
	
	@Test
	void testPaymentShouldReturnPaymentObject()
	{
		Payment payment=new Payment();
		List<Payment> paylist=new ArrayList(); 
		List<Card> cd=new ArrayList();  
		payment.setPaymentId(1);
		payment.setStatus("Succeed");
		payment.setType("Cash");
		paylist.add(payment);
		cd.add(new Card(1,"VISA","1234",LocalDate.of(2025,9,22),"HDFC"));
		Payment expected=ps.addPayment(payment);
		Payment actual=ps.getPaymentDetails(expected.getPaymentId());	
		assertEquals(expected.getPaymentId(),actual.getPaymentId());
	}
	
	@Test
	void testFindAllPaymentShouldReturnListPayment()
	{
		Payment payment=new Payment();
		List<Payment> paylist=new ArrayList(); 
		List<Card> cd=new ArrayList();  
		payment.setPaymentId(1);
		payment.setStatus("Succeed");
		payment.setType("Cash");
		paylist.add(payment);
		cd.add(new Card(1,"VISA","1234",LocalDate.of(2025,9,22),"HDFC"));
		payment.setCard(cd);
		
		Payment payment2=new Payment();
		List<Payment> paylist1=new ArrayList(); 
		List<Card> cd1=new ArrayList();  
		payment2.setPaymentId(1);
		payment2.setStatus("Fail");
		payment2.setType("Cash");
		paylist1.add(payment2);
		cd.add(new Card(1,"VISA","3456",LocalDate.of(2025,7,22),"Axis Bank"));
		payment.setCard(cd1);
		
		ps.addPayment(payment);
		ps.addPayment(payment2);
		
		List<Payment> list = ps.getAllPaymentDetails();
		assertEquals(payment2.getPaymentId(),list.get(list.size() - 1).getPaymentId());
	}
	
	@Test
	void TestUpdatePaymentShouldReturnPaymentObject() 
	{
		Payment payment=new Payment();
		List<Payment> paylist=new ArrayList(); 
		List<Card> cd=new ArrayList();  
		payment.setPaymentId(1);
		Payment add = ps.addPayment(payment);
		payment.setPaymentId(1);
		payment.setStatus("Fail");
		payment.setType("Online");
		paylist.add(payment);
		add.setCard(cd);
		
		Payment update = ps.updatePayment(payment);
		assertEquals(add.getPaymentId(), update.getPaymentId());
		assertEquals(add.getStatus(), update.getStatus());
	}

}
*/