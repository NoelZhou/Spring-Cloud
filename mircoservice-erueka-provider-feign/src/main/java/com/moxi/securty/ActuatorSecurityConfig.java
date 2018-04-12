//package com.moxi.securty;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.util.StringUtils;
//
//@Configuration  
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter{  
//        @Autowired  
//        Environment env;  
//        @Override  
//        protected void configure(HttpSecurity http) throws Exception {  
//            String contextPath = env.getProperty("management.context-path");  
//            if(StringUtils.isEmpty(contextPath)) {  
//                contextPath = "";  
//            }
//            http.csrf().disable();  
//            http.authorizeRequests()  
//                    .antMatchers("/**"+contextPath+"/**").authenticated()//拦截，并进行安全验证
//                    .anyRequest().authenticated()
//                    .and().httpBasic();  
//        }  
//        
////        @Bean
////        public PasswordEncoder passwordEncoder() {
////        	//明文编码器。这是一个不做任何操作的密码编码器，是spring提供给我们做明文测试的
////        	return NoOpPasswordEncoder.getInstance();
////        }
////        @Autowired
////        public  CustomUserDetailsService userDetailsService;
////        @Override
////		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////			auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
////		}
//     // 创建两个用户
//        @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//            auth.inMemoryAuthentication()
//                    .withUser("user").password("password").roles("USER")
//                    .and()
//                    .withUser("admin").password("password").roles("ADMIN");
//        }
//}  
//
//
//
//
//
//
//
//
