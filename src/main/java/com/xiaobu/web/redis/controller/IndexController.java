package com.xiaobu.web.redis.controller;

import com.xiaobu.web.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/setString")
    public String setString(String key,String value){
        try {
            redisService.setString(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("redis存储值异常");
        }
        return "SUCCESS";
    }

    @RequestMapping("/getString")
    public String getString(String key){
        return redisService.getString(key);
    }
}
