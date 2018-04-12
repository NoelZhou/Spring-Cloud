package com.moxi.securty;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		if("user".equals(arg0)) {
			return new SecurityUser("user", "password", "user-role");
		}else if ("admin".equals(arg0)) {
			return new SecurityUser("admin", "password", "admin-role");
		}else {
			return null;
		}
	}
	
}
