package com.zt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
@EnableTurbine
@SpringBootApplication
public class MircoserviceHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoserviceHystrixTurbineApplication.class, args);
	}
}
