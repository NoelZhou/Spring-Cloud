//package com.moxi.securty;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//@Component
//public class SecurityUser implements UserDetails{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	@SuppressWarnings("unused")
//	private Long id;
//	@SuppressWarnings("unused")
//	private String userName;
//	@SuppressWarnings("unused")
//	private String password;
//	private String role;
//	
//	public SecurityUser(String userName,String password,String role) {
//		super();
//		this.userName = userName;
//		this.password= password;
//		this.role= role;
//	}
//	
//	public SecurityUser() {
//		
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(this.role);
//		authorities.add(sga);
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//}