package com.xiaobu.web.ifs;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.config.Dictionarydata;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.model.PageModel;

import com.xiaobu.common.sms.SmsContentUtil;
import com.xiaobu.common.sms.SmsSingleSender;
import com.xiaobu.web.pro.entity.SdCollectTask;
import com.xiaobu.web.pro.entity.SdLabelTask;
import com.xiaobu.web.pro.service.SdCollectTaskService;
import com.xiaobu.web.redis.service.RedisService;

import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.service.SdDictionarydataService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sya/api/baseinterface")
public class BaseInterfaceController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(BaseInterfaceController.class);
	
	@Autowired
	private RedisService redisService;

    @Autowired
    private SdCollectTaskService sdCollectTaskService;

    @Autowired
    private SdConsumerService sdConsumerService;

    @Autowired
    private SdDictionarydataService sdDictionarydataService;

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
    @RequestMapping(value = {"/issueLabelTask"},method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object issueLabelTask(SdLabelTask sdLabelTask){

        for(int i =0;i<5;i++){
            System.out.println("个狗子的");
        }

        return "访问成功";
    }

    /**
     * 发布采集任务接口
     */
    @RequestMapping(value = {"/issueCollectTask"},method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")
    @RequiresAuthentication
    public Object issueCollectTask(SdCollectTask sdCollectTask){

        try {
            //发布任务，设置状态为1
            sdCollectTask.setStatus(Dictionarydata.IS_ISSUE.value());
            sdCollectTaskService.add(sdCollectTask);
            return actionResult(Code.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return actionResult(Code.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 采集任务列表分页
     * @param sdCollectTask
     * @param page
     * @return
     */
    @RequestMapping(value = "/selectCollectTaskInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(SysMessage.MANAGER)
    @RequiresAuthentication
    public Object selectCollectTaskInfo(SdCollectTask sdCollectTask, PageModel<SdCollectTask> page){
        try {
            PageModel<SdCollectTask> pages = sdCollectTaskService.selectConsumerInfos(sdCollectTask,page);
            return actionResult(Code.OK,"获取成功",pages);
        } catch (Exception e) {
            e.printStackTrace();
            return actionResult(Code.INTERNAL_SERVER_ERROR,"获取失败");
        }
    }

    /**
     * 获取数据字典
     * @param types
     * @return
     */
    @RequestMapping(value = "/selectDictionaryType",method = RequestMethod.GET)
    @ResponseBody
    @RequiresRoles(SysMessage.MANAGER)
    public Object selectDictionaryType(String types){
        Map<String,Object> map = new HashMap<>();
        try {
            if(StringUtils.isNotEmpty(types)){
                map  = sdDictionarydataService.selectDictionaryType(types);
            }
            return actionResult(Code.OK,map);
        } catch (Exception e) {
            e.printStackTrace();
            return actionResult(Code.INTERNAL_SERVER_ERROR);
        }
    }
}
