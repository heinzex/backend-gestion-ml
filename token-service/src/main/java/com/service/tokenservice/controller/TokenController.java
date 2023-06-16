package com.service.tokenservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.tokenservice.model.Seller;
import com.service.tokenservice.model.SellerToken;
import com.service.tokenservice.service.MLService;
import com.service.tokenservice.service.SellerService;
import com.service.tokenservice.service.SellerTokenService;

@RestController
@RequestMapping("/private/token")
public class TokenController {

	@Autowired
	MLService mlService;

	@Autowired
	SellerService SService;

	@Autowired
	SellerTokenService STService;

	@GetMapping("/user")
	public Seller newUser(@RequestParam String code) {
		List<String> tokens = mlService.sacarRefreshToken(code);
		String userID = tokens.get(0);
		String refreshToken = tokens.get(1);
		String token = tokens.get(2);

		SellerToken newST = new SellerToken(token, refreshToken, code);

		Seller seller = mlService.getDatos(userID, token);
		
		Seller savedSeller = SService.guardarActualizar(seller);
		
		newST.setSeller(savedSeller);
		
		savedSeller.setSellerToken(newST);
		
		STService.guardarActualizar(newST);
		
		return savedSeller;
	}

	@GetMapping("/{seller_id}")
	public String getToken(@PathVariable String seller_id) {
		Seller seller = SService.traerBySellerID(seller_id);
		if(seller != null) {
			SellerToken sellerToken = seller.getSellerToken();
			
			if (!sellerToken.getExpDate().isBefore(LocalDateTime.now())) {
				return sellerToken.getToken();
			} else {
				String token = mlService.sacarToken(sellerToken.getRefresh_token());
				sellerToken.setToken(token);
				sellerToken.setExpDate(LocalDateTime.now().plusHours(5));
				STService.guardarActualizar(sellerToken);
				return token;
			}
		} else {
			return "";
		}
	}
}
