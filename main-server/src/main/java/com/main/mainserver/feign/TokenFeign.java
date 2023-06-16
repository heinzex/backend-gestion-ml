package com.main.mainserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.mainserver.models.Seller;

@FeignClient(name = "token-service", path = "/private/token")
public interface TokenFeign {
	
	@GetMapping("/{seller_id}")
	public String getToken(@PathVariable String seller_id);
	
	@GetMapping("/user")
	public Object newUser(@RequestParam String code);
}
