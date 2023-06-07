package com.main.mainserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "token-service")
@RequestMapping("/api/token")
public interface TokenFeign {
	
	@GetMapping
	public String getToken();
}
