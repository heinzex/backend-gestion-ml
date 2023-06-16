package com.service.tokenservice.model;

import org.json.JSONObject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String userId;
	String nickname;
	String email;
	String first_name;
	String last_name;
	long identification;
	long phone;
	String brand_name;
	String corporate_name;
	@OneToOne(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	SellerToken sellerToken;

	public Seller() {}
	
	public Seller(String userID, JSONObject obj) {
		userId = userID;
		nickname = obj.optString("nickname", "NULL");
		email = obj.optString("email", "NULL");
		first_name = obj.optString("first_name", "NULL");
		last_name = obj.optString("last_name", "NULL");
		brand_name = obj.getJSONObject("company").optString("brand_name", "NULL");
		corporate_name = obj.getJSONObject("company").optString("corporate_name", "NULL");
		identification = obj.getJSONObject("identification").optLong("number", 0);
		phone = obj.getJSONObject("phone").optLong("number", 0);
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", userId=" + userId + ", nickname=" + nickname + ", email=" + email
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", identification=" + identification
				+ ", phone=" + phone + ", brand_name=" + brand_name + ", corporate_name=" + corporate_name
				+ ", sellerToken=" + sellerToken + "]";
	}
	
	
}
