package com.moxi.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moxi.model.Admin;
import com.moxi.model.Demo;
import com.moxi.model.ResObject;
import com.moxi.model.User;
import com.moxi.util.Constant;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
* 使用的RestController 等价于@Controller和@RequestBody
* @author admin
*
*/
@RestController

public class HelloController {
	/**
	* @RequestMapping:映射到http://127.0.0.1:8080/hello
	* @return 
	*/ 
	@RequestMapping("/hello")
	public Demo hello(){
		 Demo demo = new Demo();
	     demo.setId(1);
	     demo.setName("zhangsan");
	     demo.setCreateTime(new Date());
	   return demo;
	
	}
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getHelloFallBack")
	@GetMapping("/getHello")
	public Admin login() {
		
        return this.restTemplate.getForObject("http://localhost:8800/1",Admin.class);
	}
	
	public Admin getHelloFallBack() {
		Admin admin = new Admin();
		admin.setUserName("No User");
		admin.setPassword("-1");
		admin.setId(-1);
		return admin;
	}

}