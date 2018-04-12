package com.moxi.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.moxi.model.Admin;

@FeignClient(value="mircoservice-erueka-user",fallback=FeignClientFallback.class)
public interface UserFeignClient {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Admin getHello(@PathVariable(value="id") String id);
	
	
}

@Component
class FeignClientFallback implements UserFeignClient{

	@Override
	public Admin getHello(String id) {
		Admin admin = new Admin();
		admin.setId(-1L);
		admin.setUserName("No User");
		return admin;
	}
	
}