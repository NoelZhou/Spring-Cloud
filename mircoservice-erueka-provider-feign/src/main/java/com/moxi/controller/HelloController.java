package com.moxi.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moxi.model.Admin;
import com.moxi.model.Demo;
import com.moxi.model.User;
import com.zt.inter.UserFeignClient;

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
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/getHello")
	public Admin login1() {
		
        return this.restTemplate.getForObject("http://mircoservice-erueka-user/app/login",Admin.class);
	}
//	@Autowired
//	private UserFeignClient ufc;
//	@GetMapping("/getHello/{id}")
//	public Admin login(@PathVariable String id) {
//		
//        return this.ufc.getHello(id);
//	}
	
	@GetMapping("/log-user-instance")
	public void logUserInstance() {
		ServiceInstance si = this.loadBalancerClient.choose("mircoservice-erueka-user");
		//打印当前选择的是哪个节点
		System.out.println("{"+si.getServiceId()+"}:{"+si.getHost()+"}:{"+si.getPort()+"}");
	}
	
	
	@Autowired
	private DiscoveryClient dc;
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo(){
		return this.dc.getInstances("mircoservice-erueka-user");
	}

}











