package com.xiaobu.common.sms;


import java.util.ArrayList;

public class SmsContentUtil {
    //短信应用SDK AppID
    public static final int APPID=1400116117;

    //短信应用SDK APPKey
    public static final String APPKEY="c58561720d9fcb4fd232b94a9baae87f";

    //短信模板ID，需要在短信应用中申请
    public static final int TTEMPLATEID=160753;

    //签名
    public static final String SMSSIGN = "deno";

    //中国地区电话国家码
    public static  final  String nationCode="86";

    //验证码，时间
    public static final ArrayList<String> list = new ArrayList<String>(){{add(getcode());add("2");}};

    //获取随机四位数的验证码
    private static String getcode() {
    	String code = (int) (Math.random() * 9000 + 1000) + "";
    	return code;
    }

}
