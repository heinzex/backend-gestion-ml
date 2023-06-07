package com.service.tokenservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class TokenController {

	@GetMapping
	public ResponseEntity<String> getToken() {
		return ResponseEntity.ok("Bearer etc....");
	}
	
}
