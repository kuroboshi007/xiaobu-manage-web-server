package com.xiaobu.Test;

import java.util.Date;
import java.util.Random;

import com.xiaobu.common.config.Dictionarydata;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.util.MD5Util;

public class Test {

    public static void main(String[] args){
    	/*String password ="123456";
    	Random rand = new Random();
    	String randStr = "";
    	int count =0;
    	//生成随机数串，例：AZTR987dsds
    	*//*int index;
    	boolean[] flags =new boolean[SysMessage.letters.length];
    	for(int i=0;i<10;i++) {
    		do{
				index = rand.nextInt(SysMessage.letters.length); 
			}while(flags[index]==true);
			char c = SysMessage.letters[index];
			randStr += c;
			flags[index]=true;

    	}*//*
    	while(true) {
    		int index = rand.nextInt(SysMessage.letters.length);
    		char temp = SysMessage.letters[index];
    		randStr+=temp;
    		count++;
    		if(count==10) {
    			break;
    		}
    	}
    	//对用户表单输入密码进行首次md5加密
    	String md5Password = MD5Util.MD5(password);
    	//将加密过的password进行与随机数randStr进行一次md5加密
    	String passWordandSalt = MD5Util.MD5(md5Password+randStr);
    	String before5 = randStr.substring(0, 5);
    	String after5 = randStr.substring(5);
    	System.out.println(randStr);
    	System.out.println(before5);
    	System.out.println(after5);
    	System.out.println(passWordandSalt);
    	String user_password = before5+passWordandSalt+after5;
    	System.out.println(user_password);*/
        System.out.println(Dictionarydata.CHECKOUT_PASS);
    }
}
