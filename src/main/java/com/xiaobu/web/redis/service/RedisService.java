package com.xiaobu.web.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setString(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String getString(String key){
        return  redisTemplate.opsForValue().get(key);
    }
}
