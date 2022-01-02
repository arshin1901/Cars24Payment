package com.cars.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Payment")
public class Payment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty
	@Column(name="payment id")
	private int paymentId;
	@Column(name="Type")
	private String type;
	@Column(name="Status")
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Card card;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
	public Payment()
	{
	 
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

	public Payment(int id,int paymentId, String type, String status, Card card) {
		super();
		this.id=id;
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	
	
 

 
}
