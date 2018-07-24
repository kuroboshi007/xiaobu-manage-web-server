package com.xiaobu.common.sms;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

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

    //模板集合
    public static final ArrayList<String> list = new ArrayList<String>(){{add("2");}};

}
