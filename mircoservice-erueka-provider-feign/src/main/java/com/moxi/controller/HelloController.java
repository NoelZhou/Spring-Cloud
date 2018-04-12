package com.moxi.controller;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moxi.inter.UserFeignClient;
import com.moxi.model.Admin;
import com.moxi.model.Demo;

/**
* 使用的RestController 等价于@Controller和@RequestBody
* @author admin
*
*/
@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
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
	private UserFeignClient ufc;
	@GetMapping("/{id}")
	public Admin login(@PathVariable String id) {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(principal instanceof UserDetails) {
//			UserDetails user = (UserDetails)principal;
//			Collection<? extends GrantedAuthority>collection = user.getAuthorities();
//			for (GrantedAuthority grantedAuthority : collection) {
//				HelloController.LOGGER.info("当前用户是{}，角色是{}",user.getUsername(),grantedAuthority.getAuthority());
//			}
//			return null;
//		}else {
			return this.ufc.getHello(id);
//		}
	}

	
	
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/getHello")
	public Admin login1() {
		
        return this.restTemplate.getForObject("http://mircoservice-erueka-user/app/login",Admin.class);
	}

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











