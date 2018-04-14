package com.zt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
public class MircoserviceQuartzDemoApplication {

	
	/**
	 * 在这里我们使用@Bean注入 fastJsonHttpMessageConvert
	 * fastjson第三方部署
	 * @return
	 */
    @Bean
    public HttpMessageConverters fashJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
         
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
         
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter =fastConverter;
         
        return new HttpMessageConverters(converter);
         
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MircoserviceQuartzDemoApplication.class, args);
	}
}
