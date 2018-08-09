package com.xiaobu.web.ifs;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.sms.SmsContentUtil;
import com.xiaobu.common.sms.SmsSingleSender;
import com.xiaobu.web.pro.entity.SdLabelTask;
import com.xiaobu.web.redis.service.RedisService;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/baseinterface")
public class BaseInterfaceController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(BaseInterfaceController.class);
	
	@Autowired
	private RedisService redisService;

    /**
     * 短信验证码接口
     */
    @RequestMapping(value={"/obtainSms"},method=RequestMethod.POST )
    @ResponseBody
    public Object obtainSms(String number){
        SmsSingleSender ssender = new SmsSingleSender(SmsContentUtil.APPID, SmsContentUtil.APPKEY);

        try {
            
            SmsSingleSenderResult result = ssender.sendWithParam(SmsContentUtil.nationCode,number,SmsContentUtil.TTEMPLATEID,SmsContentUtil.list,SmsContentUtil.SMSSIGN,"","");
            if(result.errMsg.equals("OK")) {
            	logger.info("电话"+number+",验证码："+SmsContentUtil.list.get(0));
            	//如果发送成功存入redis,设置过期时间为120秒
            	//redisService.set(number, SmsContentUtil.list.get(0),120,TimeUnit.SECONDS);
            	redisService.setString(number, SmsContentUtil.list.get(0));
            	return actionResult(Code.OK,result.errMsg);
            }else {
            	return actionResult(Code.BAD_REQUEST,result.errMsg);
            }
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发布标注任务接口
     */
    @RequestMapping(value = {"/issueLabelTask"},method = RequestMethod.GET)
    @ResponseBody
    //@RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresPermissions("Manager")
    public Object issueLabelTask(SdLabelTask sdLabelTask){


        return "访问成功";
    }
}
