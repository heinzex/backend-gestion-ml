package com.main.mainserver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.mainserver.feign.TokenFeign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class TokenController {

	@Autowired
	private TokenFeign tokenFeign;

	@CircuitBreaker(name = "microservice", fallbackMethod = "exceptionFallback")
	@GetMapping("21")
	public ResponseEntity<Object> newUser(@RequestParam String code) {
		Object seller = tokenFeign.newUser(code);
		return ResponseEntity.ok(seller);
	}

	@CircuitBreaker(name = "microservice", fallbackMethod = "exceptionFallback")
	@GetMapping("/{seller}/token")
	public ResponseEntity<String> getToken(@PathVariable String seller) {
		String token = tokenFeign.getToken(seller);
		return ResponseEntity.ok(token);
	}
	
	private ResponseEntity<Map> exceptionFallback(RuntimeException ex) {
		Map<String, String> exception = new HashMap<>();		
		exception.put("error", "hubo un error");
		exception.put("message", ex.getMessage());
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
