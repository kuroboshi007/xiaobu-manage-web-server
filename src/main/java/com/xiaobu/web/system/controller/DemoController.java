package com.xiaobu.web.system.controller;

import javax.servlet.http.HttpServletRequest;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.constant.SessionAttr;
import com.xiaobu.web.system.entity.SdUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DemoController extends BaseController {
    
	//默认访问登录页
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String loginJSP(HttpServletRequest request) {

		SdUser user = (SdUser) request.getSession().getAttribute(SessionAttr.USER_LOGIN.getValue());
		request.setAttribute("user", user);
		return "index";
	}
}
