package com.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.entities.Payment;


@Repository("er")
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
	//Payment addPayment(Payment payment);
	//Payment removePayment(long id);
	//Payment updatePayment(long id,Payment payment);
	//Payment getPaymentDetails(long id);
	//List <Payment>getAllPaymentDetails();
}
