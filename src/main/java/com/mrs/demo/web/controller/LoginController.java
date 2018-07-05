package com.mrs.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrs.demo.web.entity.SysUser;
import com.mrs.demo.web.service.SysUserService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SysUserService sysUserService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		logger.info("跳转到登陆页面");
		
		return "/pages/login";
	}
	
	@RequestMapping("/checklogin")
	public String checklogin(HttpServletRequest request,SysUser sysuser) {
		
		try {
			
			SysUser user = sysUserService.findByUsername(sysuser);
			
			if(user != null){
				
				request.setAttribute("user", user);
			
				return "/pages/index";
			} else {
				return "/pages/index";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}
}
