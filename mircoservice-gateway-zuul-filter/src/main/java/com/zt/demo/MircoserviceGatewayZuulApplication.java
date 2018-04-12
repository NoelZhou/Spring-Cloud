package com.zt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zt.demo.filter.PreRequestLogFilter;

@EnableZuulProxy
@SpringBootApplication
public class MircoserviceGatewayZuulApplication {

	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MircoserviceGatewayZuulApplication.class, args);
	}
}
