package com.mrs.demo.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrs.demo.common.base.BaseController;
import com.mrs.demo.common.config.Code;
import com.mrs.demo.common.constant.SessionAttr;
import com.mrs.demo.common.constant.SysMessage;
import com.mrs.demo.common.util.MD5Util;
import com.mrs.demo.web.entity.SysUser;
import com.mrs.demo.web.service.SysUserService;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Autowired
	private SysUserService sysUserService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		logger.info("跳转到登陆页面");
		
		return "/pages/login";
	}
	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	@ResponseBody
	public Object checklogin(HttpServletRequest request,SysUser sysuser) {
		
		try {
			
			SysUser user = sysUserService.findByUsername(sysuser);
			
			if(user != null){
				String password = sysuser.getPassword();
				String MD5PWD = MD5Util.MD5(password);
				if(MD5PWD.equals(user.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute(SessionAttr.USER_LOGIN.getValue(), user);
					logger.info(user.getUsername() + SysMessage.LOGIN_SUCCESS);
					//request.setAttribute("user", user);
				}else {
					logger.info(user.getUsername() + SysMessage.LOGIN_USER_INFO_ERROR);
					return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_INFO_ERROR);
				}
				return actionResult(Code.OK,SysMessage.LOGIN_SUCCESS);
			} else {
				return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return actionResult(Code.INTERNAL_SERVER_ERROR,SysMessage.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		
		
		
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		logger.info(user.getUsername()+SysMessage.LOGIN_USER_OUT);
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "/pages/login";
	}
}
