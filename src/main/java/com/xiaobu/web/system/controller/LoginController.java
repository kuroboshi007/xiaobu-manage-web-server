package com.xiaobu.web.system.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SessionAttr;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.util.JwtManager;
import com.xiaobu.common.util.MD5Util;

import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.entity.SdManager;
import com.xiaobu.web.system.entity.SdOrganization;
import com.xiaobu.web.system.entity.SdUser;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.service.SdManagerService;
import com.xiaobu.web.system.service.SdOrganizationService;
import com.xiaobu.web.system.service.SdUserService;


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
    private SdUserService sdUserService;
    
    @Autowired
	private SdOrganizationService sdOrganizationService;
	 
	@Autowired
	private SdManagerService sdManagerService;

    @Autowired
    private SdConsumerService sdConsumerService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	@ResponseBody
	public Object checklogin(HttpServletRequest request,String username,String password,String type) {
		String userPassword = "";
		Integer userId = null;
		
		try {
			//查詢系统用戶信息
			if(type.equals("Manager")) {
				SdManager sdManager=sdManagerService.selectByUsername(username);
				if(sdManager == null) {
					return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
				}
				userPassword = sdManager.getPassword();
				userId = sdManager.getId();
				//查询甲方用户信息
			}else if(type.equals("Consumer")){
                SdConsumer sdConsumer = sdConsumerService.selectByUsername(username);
                if(sdConsumer ==null){
                    return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
                }
                userPassword = sdConsumer.getPassword();
                userId = sdConsumer.getId();
                //查询团队用户信息
            }else {
				SdOrganization sdOrganization = sdOrganizationService.selectByUsername(username);
				if(sdOrganization == null) {
					return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_NOT_EXIST);
				}
				userPassword = sdOrganization.getPassword();
				userId = sdOrganization.getId();
			}
			//首先對用戶表單中的password進行一次MD5加密
			String MD5password = MD5Util.MD5(password);
			//获取前五位
			String before5 = userPassword.substring(0, 5);
			//获取后五位
			String after5 = userPassword.substring(userPassword.length()-5);
			//获取剔除盐之后的password
			String pwd =  userPassword.substring(5, userPassword.length()-5);
			//生成注册時隨機生成的盐
			String salt = before5+after5;
			String passWordandSalt = MD5Util.MD5(MD5password+salt);
			//验证密码
			if(!pwd.equals(passWordandSalt)) {
				logger.info(username + SysMessage.LOGIN_USER_INFO_ERROR);
			    return actionResult(Code.BAD_REQUEST,SysMessage.LOGIN_USER_INFO_ERROR);
			}
			logger.info(username + SysMessage.LOGIN_SUCCESS);
			String token =JwtManager.createToken(username,userId,type);
			return actionResult(Code.OK,SysMessage.LOGIN_SUCCESS,token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return actionResult(Code.INTERNAL_SERVER_ERROR,SysMessage.INTERNAL_SERVER_ERROR);
		}
		/* // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = "admin"
        if ("user".equals(role)) {
            return actionResult(Code.OK,"欢迎登陆");
        }
        if ("admin".equals(role)) {
            return actionResult(Code.OK,"欢迎来到管理员页面");
        } 
        return actionResult(Code.BAD_REQUEST,"权限错误！");*/
	}
	
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		SdUser user = (SdUser) session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		logger.info(user.getUsername()+SysMessage.LOGIN_USER_OUT);
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "/pages/login";
	}
	
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)
    public Object getMessage() {
        return actionResult(Code.OK,"您拥有管理员权限，可以获得该接口的信息！");
    }


    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return actionResult(Code.OK,"成功注销！");
    }*/
	
	
}
