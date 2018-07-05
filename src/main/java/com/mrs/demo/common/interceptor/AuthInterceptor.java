package com.mrs.demo.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class AuthInterceptor implements HandlerInterceptor{

	/*
	 * 视图渲染之后的操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
			throws Exception {

	}

	/*
	 * 处理请求完成后视图渲染之前的处理操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {

	}

	/*
	 * 进入controller层之前拦截请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
			
			// session失效时，ajax请求拦截
			String requestType = request.getHeader("X-Requested-With");
			if(StringUtils.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
				
				response.setHeader("sessionstatus", "timeout");  
				response.sendError(518, "session timeout.");  
				
		    }else { 
		    	
		    	// 跳转到登录页面
				request.getRequestDispatcher("/login/login").forward(request, response);
				//request.getRequestDispatcher("Login.jsp").forward(request, response);
		    }
			return false;
	}
}
