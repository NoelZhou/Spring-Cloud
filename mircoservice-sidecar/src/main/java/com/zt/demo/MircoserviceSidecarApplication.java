package com.zt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class MircoserviceSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoserviceSidecarApplication.class, args);
	}
}
