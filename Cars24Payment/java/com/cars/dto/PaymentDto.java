package com.cars.dto;

//package com.cars.customerdto;

import java.time.LocalDate;

import com.cars.entities.Card;
//import com.cars.entities.Address;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PaymentDto {
	private int id;
	private int paymentId;
	private String type;
	private String status;
	
	private Card card;
	
	public PaymentDto(){
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public PaymentDto(int id, int paymentId, String type, String status, Card card) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	
	
}
