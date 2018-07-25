package com.xiaobu.web.redis.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis封装类
 * @author MuRunSen
 *
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    //新增一个字符串类型的值，key是键，value是值
    public void setString(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
    //根据key值查找value
    public String getString(String key){
        return  redisTemplate.opsForValue().get(key);
    }
    
    //在原有的值基础上新增字符串到末尾
    public Integer appendString(String key,String value) {
    	return redisTemplate.opsForValue().append(key,value);
    }
    
    //截取key键对应值得字符串，从开始下标位置开始到结束下标的位置(包含结束下标)的字符串。
    public String get(String key,long start,long end) {
    	return  redisTemplate.opsForValue().get(key,start,end);  
    }
    
    //获取原来key键对应的值并重新赋新值
    public String getAndSet(String key,String value) {
    	return redisTemplate.opsForValue().getAndSet(key,value); 
    }
    
    //获取指定字符串的长度
    public long stringValueLength(String key) {
    	return redisTemplate.opsForValue().size(key);
    }
    
    //设置变量值的过期时间
    public void set(String key,String value,long timeout,TimeUnit unit) {
	   redisTemplate.opsForValue().set(key,value,timeout,unit);
    };
}
