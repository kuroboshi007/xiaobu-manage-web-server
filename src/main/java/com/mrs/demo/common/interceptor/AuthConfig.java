package com.mrs.demo.common.interceptor;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截去注册类
 * 
 * @author Mmmmm
 *
 */
@Configuration
public class AuthConfig implements WebMvcConfigurer{

	@Resource
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 自定义拦截器，添加拦截路径和排除拦截路径,excludePathPatterns添加放行机制，不然死循环
		registry.addInterceptor(authInterceptor).addPathPatterns("/**")
		        .excludePathPatterns("/login/login","/login/checklogin");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
