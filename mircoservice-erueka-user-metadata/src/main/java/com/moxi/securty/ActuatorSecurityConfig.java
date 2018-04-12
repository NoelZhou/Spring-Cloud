package com.moxi.securty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.StringUtils;

@Configuration  
@EnableWebSecurity  
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter{  
        @Autowired  
        Environment env;  
        @Override  
        protected void configure(HttpSecurity http) throws Exception {  
            String contextPath = env.getProperty("management.context-path");  
            if(StringUtils.isEmpty(contextPath)) {  
                contextPath = "";  
            }
            http.csrf().disable();  
            http.authorizeRequests()  
//                    .antMatchers("/**"+contextPath+"/**").authenticated()//拦截，并进行安全验证
                    .anyRequest().permitAll()//其他url请求不需要安全验证
                    .and().httpBasic();  
            
        }  
        
        // 创建两个用户
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER")
                    .and()
                    .withUser("admin").password("password").roles("ADMIN");
        }
}  