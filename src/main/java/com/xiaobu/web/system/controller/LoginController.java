package com.xiaobu.web.system.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SessionAttr;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.util.JwtManager;
import com.xiaobu.common.util.MD5Util;
import com.xiaobu.common.util.ValidateUtil;
import com.xiaobu.web.system.entity.SdUser;
import com.xiaobu.web.system.service.SdUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
    @Autowired
    private SdUserService sdUserService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		logger.info("跳转到登陆页面");
		
		return "/pages/login";
	}
	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	@ResponseBody
	public Object checklogin(HttpServletRequest request,String username,String password) {
		try {
			//查詢用戶信息
			SdUser user = sdUserService.selectByname(username);
			//User user = userService.findByUsername(username);
			//SysUser user = sysUserService.findByUsername(username);
			if(user == null) {
				return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
			}
			//首先對用戶表單中的password進行一次MD5加密
			String MD5password = MD5Util.MD5(password);
			//获取前五位
			String before5 = user.getPassword().substring(0, 5);
			//获取后五位
			String after5 = user.getPassword().substring(user.getPassword().length()-5);
			//获取剔除盐之后的password
			String pwd =  user.getPassword().substring(5, user.getPassword().length()-5);
			//生成注册時隨機生成的盐
			String salt = before5+after5;
			String passWordandSalt = MD5Util.MD5(MD5password+salt);
			//验证密码
			if(!pwd.equals(passWordandSalt)) {
				logger.info(user.getName() + SysMessage.LOGIN_USER_INFO_ERROR);
			    return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_INFO_ERROR);
			}
			logger.info(user.getName() + SysMessage.LOGIN_SUCCESS);
			String token =JwtManager.createToken(user);
			return actionResult(Code.OK,SysMessage.LOGIN_SUCCESS,token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
//		if(ValidateUtil.isNotEmpty(object)(request.getParameter("name"))) {
//			
//		}
		
		HttpSession session = request.getSession();
		SdUser user = (SdUser) session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		logger.info(user.getUsername()+SysMessage.LOGIN_USER_OUT);
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "/pages/login";
	}
}
