package com.xiaobu.Test;

import java.util.Date;

public class Test {

    public static void main(String[] args){
        //获取时间戳
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        System.out.println(nowMillis);
    }
}
