package com.cars.controllertest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cars.controllers.PaymentController;
import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;
import com.cars.service.IPaymentService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/*import com.cars.controllers.CustomerController;
import com.cars.controllers.PaymentController;
import com.cars.customerdto.CustomerDto;
import com.cars.entities.Address;
import com.cars.entities.Customer;
import com.cars.entities.Payment;
import com.cars.responses.ResponseInfo;
import com.cars.service.ICustomerService;
import com.cars.service.IPaymentService;*/

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ControllerTestCases{

@InjectMocks
PaymentController paymentcontroller;
@Mock
IPaymentService ps;
@Mock
Payment payment;
@Mock
PaymentDto paymentdto;

@Mock
Payment c;
@BeforeEach
public void startup() {
	MockitoAnnotations.initMocks(this);
	Payment p=new Payment(12,1,"Cash","Succeed",null);
	
}


@Test
public void testaddCustomer() {       //add customer
	Mockito.when(ps.addPayment(paymentdto)).thenReturn(payment);  //
	assertEquals(payment,paymentcontroller.addPayment(paymentdto));
	Mockito.verify(ps).addPayment(paymentdto);
}



@Test
public void testGetAllCustomer() {			//get all customer
	Mockito.when(ps.getAllPaymentDetails()).thenReturn(Arrays.asList(payment));
	assertEquals(Arrays.asList(payment),paymentcontroller.getAllPaymentDetails());
	Mockito.verify(ps).getAllPaymentDetails();
}



@Test
public void testGetCustomerById() {   //get customer by id

	Mockito.when(ps.getPaymentDetails(101)).thenReturn(payment);
	assertEquals(payment,paymentcontroller.getPaymentDetails(101));
	Mockito.verify(ps).getPaymentDetails(101);
}



@Test
public void testUpdateCustomer() {		//Update customer
	boolean b=true;
	Payment c1=new Payment(12,1,"Cash","Succeed",null);
	 when(ps.updatePayment(12,paymentdto)).thenReturn(c1);
	 Payment updatec=ps.updatePayment(12,paymentdto);
	 assertEquals(c1,updatec);	 
}



@Test
public void testDeleteCustomer() {			//delete customer by id
	Payment c1=new Payment(12,1,"Cash","Succeed",null);
	when(ps.removePayment(c1.getPaymentId())).thenReturn("REMOVED");
	String status = ps.removePayment(1);
	assertEquals("REMOVED",status);
	
}
}
