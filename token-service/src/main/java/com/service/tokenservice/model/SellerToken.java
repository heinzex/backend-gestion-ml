package com.service.tokenservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class SellerToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String token;
	String refresh_token;
	String code;
	@JsonIgnore
	@JoinColumn(name = "seller_id")
	@OneToOne
	Seller seller;
	LocalDateTime expDate = LocalDateTime.now().plusHours(5);
	
	public SellerToken() {}
	
	public SellerToken(String token, String refresh_token, String code) {
		super();
		this.token = token;
		this.refresh_token = refresh_token;
		this.code = code;
	}

	public SellerToken(String token, String refresh_token, String code, Seller seller) {
		super();
		this.token = token;
		this.refresh_token = refresh_token;
		this.code = code;
		this.seller = seller;
	}
}
