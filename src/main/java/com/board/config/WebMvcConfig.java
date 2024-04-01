package com.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.interceptor.LoginCheckInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	// 중요 폴더 위치 : WebMvcConfig.java
	// 폴더 위치 중요 : 반드시 main() 함수가 있는 class(Board5Application)의 package(com.board) 아래에 .config package를 생성해서 저장
	// com.board.config
	// 용도: Spring legacy project 설정을 .xml에 저장
	//       SpringBoot Project는 설정을 WebMvcConfig.java 에 저장
	
	// 각종 설정 정보를 저장하는 곳
	
	@Autowired
	   private  LoginCheckInterceptor   loginCheckInterceptor;
	   
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {

	       System.out.println("okokok");
	        registry.addInterceptor( loginCheckInterceptor )
	                .addPathPatterns("/**")      // http://localhost:9090/
	                .addPathPatterns("/**/*")    
	                .excludePathPatterns("/log*","/css/**", "/img/**", "/js/**");
	        
	    }
}
