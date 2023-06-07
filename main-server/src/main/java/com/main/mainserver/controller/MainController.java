package com.main.mainserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.mainserver.feign.TokenFeign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	TokenFeign tokenFeign;
	
	@CircuitBreaker(name = "microservice", fallbackMethod = "exceptionFallback")
	@GetMapping("/{seller}/token")
	public ResponseEntity<String> getToken(@PathVariable String seller){
		String token = tokenFeign.getToken();
		return ResponseEntity.ok(token);
	}
	
	private ResponseEntity<String> exceptionFallback(RuntimeException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
