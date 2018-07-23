package com.xiaobu.web.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.util.MD5Util;
import com.xiaobu.common.util.RandomUtil;
import com.xiaobu.web.system.entity.SdUser;
import com.xiaobu.web.system.service.SdUserService;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signup")
public class SignupController extends BaseController{

	@Autowired
	private SdUserService sdUserService;
	
    @RequestMapping(value="/init",method = RequestMethod.GET)
    public String init(HttpServletRequest request){
        System.out.println("跳转到注册页面");
        return "/pages/signup";
    }
    
    
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    @ResponseBody
    public Object signup(SdUser sdUser) {
    	
    	//注册前检查用户名是否重复
    	if(sdUserService.selectByname(sdUser.getNickname())!=null) {
    		return actionResult(Code.BAD_REQUEST,"用户名已存在");
    	}
    	
    	//获取随机串
    	String randStr = RandomUtil.createRandomChar(10);
    	
    	//对用户表单输入密码进行首次md5加密
    	String md5Password = MD5Util.MD5(sdUser.getPassword());
    	//将加密过的password进行与随机数randStr进行一次md5加密
    	String passWordandSalt = MD5Util.MD5(md5Password+randStr);
    	//将随机生成的字符串截取前五位与后五位
    	String before5 = randStr.substring(0, 5);
    	String after5 = randStr.substring(5); 
    	//最终用户存进数据库的密码
    	String user_password = before5+passWordandSalt+after5;
    	sdUser.setPassword(user_password);
    	
    	try {
    		sdUserService.insert(sdUser);
			return actionResult(Code.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return actionResult(Code.INTERNAL_SERVER_ERROR);
		}
    }
}
