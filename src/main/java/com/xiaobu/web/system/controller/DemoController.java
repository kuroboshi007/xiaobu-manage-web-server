package com.xiaobu.web.system.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.util.JwtManager;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.service.SdManagerService;
import com.xiaobu.web.system.service.SdOrganizationService;
import com.xiaobu.web.system.service.SdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DemoController extends BaseController {
    @Autowired
    private SdOrganizationService sdOrganizationService;

    @Autowired
    private SdManagerService sdManagerService;

    @Autowired
    private SdConsumerService sdConsumerService;

    @Autowired
    private SdUserService sdUserService;
    
	//默认访问登录页
	/*@RequestMapping(value="/",method=RequestMethod.GET)
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setAttribute("name","admin");
        response.sendRedirect("/login");
		System.out.println("进入登录页");

	}*/

    //默认访问登录页
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String loginHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {



        System.out.println("进入登录页");
        return "index";
    }

    //默认访问登录页
    @RequestMapping(value="main",method=RequestMethod.GET)
    public String loginMain(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setAttribute("userInfo", "admin");
        System.out.println("进入主页");
        return "main/index";
    }


    //进入主页面
    /*@RequestMapping(value="main",method=RequestMethod.GET)
    public String logiMain(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        if(cookies != null && cookies.length>0){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("Token")){
                    token  = cookie.getValue();
                }
            }
        }
        Map<String,Object> map = JwtManager.TokenDecompose(token);
        String username = map.get("username").toString();
        Map<String,Object>  userInfo = sdUserService.getUserInfo(map,username);
        //查詢系统用戶信息
        request.setAttribute("userInfo", userInfo);
        System.out.println("进入main页");
        return "main";
    }*/
}
