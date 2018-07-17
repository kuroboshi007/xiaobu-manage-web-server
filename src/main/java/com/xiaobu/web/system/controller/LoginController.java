package com.xiaobu.web.system.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SessionAttr;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.util.MD5Util;
import com.xiaobu.web.system.entity.SysUser;
import com.xiaobu.web.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
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
	public Object checklogin(HttpServletRequest request,String username,String password) {
		try {
		    //查询用户信息
			SysUser user = sysUserService.findByUsername(username);
			if(user == null){
				return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
			}
			//验证密码
            if(MD5Util.verify(password,user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttr.USER_LOGIN.getValue(), user);

                String token = UUID.randomUUID().toString();

                user.setPassword(null);


                logger.info(user.getUsername() + SysMessage.LOGIN_SUCCESS);
                return actionResult(Code.OK,SysMessage.LOGIN_SUCCESS);
            }else{
                logger.info(user.getUsername() + SysMessage.LOGIN_USER_INFO_ERROR);
                return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_INFO_ERROR);
            }

		} catch (Exception e) {
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
		
		
		
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		logger.info(user.getUsername()+SysMessage.LOGIN_USER_OUT);
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "/pages/login";
	}
}
