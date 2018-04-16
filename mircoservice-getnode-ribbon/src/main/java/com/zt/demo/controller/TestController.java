package com.zt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class TestController {
		
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/test")
	public String  testController() {
		return this.restTemplate.getForObject("http://microservice-sidecar-node-service/", String.class);
	}
}
