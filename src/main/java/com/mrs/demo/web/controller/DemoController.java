package com.mrs.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrs.demo.common.base.BaseController;
import com.mrs.demo.common.constant.SessionAttr;
import com.mrs.demo.web.entity.SysUser;

@Controller
@RequestMapping("/")
public class DemoController extends BaseController{

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("进入了");
		return "/pages/login";
	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("进入了");
		SysUser user = (SysUser) request.getSession().getAttribute(SessionAttr.USER_LOGIN.getValue());
		request.setAttribute("user", user);
		return "/pages/index";
	}
	
}
