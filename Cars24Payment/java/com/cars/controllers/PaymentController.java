package com.cars.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cars.dto.PaymentDto;
import com.cars.entities.Payment;
import com.cars.responses.Response;
import com.cars.service.IPaymentService;


//import io.swagger.annotations.ApiOperation;


@RestController
public class PaymentController {
	Logger logger=LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	IPaymentService ps;
	@PostMapping("/payment")
	public Payment addPayment(@RequestBody PaymentDto paymentdto)
	{
		return ps.addPayment(paymentdto);
	}

	/*//@ApiOperation("Used to insert Movie records")
	@PostMapping("/payment")
	public ResponseEntity<Response> addPayment(@Valid @RequestBody Payment payment, HttpServletRequest req)
	{
		Response ri= null;
		if(ps.addPayment(payment))
		{	
			String str=req.getRequestURI();
			int stscode=HttpStatus.CREATED.value();
			ri= new Response(str,stscode,HttpStatus.CREATED,"Added Successfully");
		}
		//logger.info("Inserted values into table");
		return new ResponseEntity<>(ri,HttpStatus.CREATED);
	}*/

	@DeleteMapping("/payment/byId/{pid}")
	String removePayment(@PathVariable("pid")int id)
	{
		ps.removePayment(id);
		return "Deleted Successfully";
	}


	@PutMapping("/payment/{pid}")
	Payment updatePayment(@PathVariable("pid")int id,@RequestBody PaymentDto paymentDto)
	{
		return ps.updatePayment(id,paymentDto);
	}

	/*@PutMapping("/updateMovie")
	public ResponseEntity<Response> updatePayment(@Valid @RequestBody Payment payment , HttpServletRequest req) {
		Response r = new Response();
		if(ps.updatePayment(payment)) {
			r.setUri(req.getRequestURI());
			r.setStatusCode(HttpStatus.ACCEPTED.value());
			r.setStatusName(HttpStatus.ACCEPTED);
			r.setMessage("Updated Successfully");
		}
		return new ResponseEntity<>(r,HttpStatus.ACCEPTED);
	}*/


	@GetMapping("/payment/byId/{pid}")
	public
	Payment getPaymentDetails(@PathVariable("pid") int id)
	{
		return ps.getPaymentDetails(id);
	}

	@GetMapping("/payment")
	public
	List<Payment> getAllPaymentDetails()
	{
		return ps.getAllPaymentDetails();
	}
}
