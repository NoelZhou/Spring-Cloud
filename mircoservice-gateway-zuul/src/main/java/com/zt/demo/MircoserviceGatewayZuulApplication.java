package com.zt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MircoserviceGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoserviceGatewayZuulApplication.class, args);
	}
}
