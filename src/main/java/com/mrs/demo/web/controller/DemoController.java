package com.mrs.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("进入了");
		return "/pages/login";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("进入了");
		return "/pages/index";
	}
}
