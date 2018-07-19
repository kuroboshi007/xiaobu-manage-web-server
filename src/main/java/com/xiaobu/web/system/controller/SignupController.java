package com.xiaobu.web.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @RequestMapping(value="/signup",method = RequestMethod.GET)
    public String sigup(HttpServletRequest request){
        System.out.println("跳转到注册页面");
        return "/pages/sigup";
    }
}
