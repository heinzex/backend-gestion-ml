package com.main.mainserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainServerApplication.class, args);
	}

}
