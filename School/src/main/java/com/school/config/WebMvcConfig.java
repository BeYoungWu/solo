package com.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.school.interceptor.AuthInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // web mvc 설정 클래스

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new AuthInterceptor())
				.addPathPatterns("/board/**")
				.addPathPatterns("/parentBoard/**")
				.addPathPatterns("/studentBoard/**");
		
	}
	
}
