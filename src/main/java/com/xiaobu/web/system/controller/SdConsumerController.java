package com.xiaobu.web.system.controller;

import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.model.PageModel;
import com.xiaobu.common.util.PasswordUtil;
import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.service.SdConsumerService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
* 描述：标注平台用户controller
* @author MuRunSen
* @date 2018-08-08 09:39:32
*/
@Controller
@RequestMapping("/sdConsumer")
public class SdConsumerController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SdConsumerController.class);

    @Autowired
    private SdConsumerService sdConsumerService;


    /**
     * 甲方信息列表List接口
     * @Author Luxinli
     */
    @RequestMapping(value = {"/selectConsumerInfo"},method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object selectConsumerInfo(SdConsumer sdConsumers,PageModel<SdConsumer> page){

        try {
            PageModel<SdConsumer> pages = sdConsumerService.selectConsumerInfos(sdConsumers,page);
            return actionResult(Code.OK,"获取成功",pages);
        } catch (Exception e) {
            e.printStackTrace();
            return actionResult(Code.INTERNAL_SERVER_ERROR,"获取失败");
        }
    }

    /**
     * 新增甲方信息接口
     * @Author Luxinli
     */
    @RequestMapping(value = "/insertConsumerInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object insertConsumerInfo(SdConsumer sdConsumer){
        try {
                //判断该用户是否存在，不存在新增
                if(sdConsumerService.selectByUsername(sdConsumer.getUsername()) != null ){
                    logger.info("该用户已存在");
                    return actionResult(Code.BAD_REQUEST,SysMessage.SIGNUP_USER_EXIST);
                }
                else{
                    //不存在插入该用户信息
                    //对用户的密码进行加密
                    String encryption_pwd =  PasswordUtil.encryptionPwd(sdConsumer.getPassword());
                    sdConsumer.setPassword(encryption_pwd);
                  sdConsumerService.insertConsumerInfo(sdConsumer);
                  logger.info(sdConsumer.getUsername()+"新增成功");
                  return actionResult(Code.OK,"新增成功");
                }
        }catch (Exception e){
            e.printStackTrace();
            logger.info(sdConsumer.getUsername()+"新增失败");
            return  actionResult(Code.INTERNAL_SERVER_ERROR,"新增失败");
        }

    }


    /**
     * 修改甲方信息接口
     * @param sdConsumer
     * @Author Luxinli
     * @return
     */
    @RequestMapping(value = "/updateConsumerInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public  Object updateConsumerInfo(SdConsumer sdConsumer){
        try {
            sdConsumerService.updateConsumerInfo(sdConsumer);
            logger.info(sdConsumer.getUsername()+"修改成功");
            return actionResult(Code.OK,SysMessage.COMMON_UPDATE_SUCCESS);
        }catch (Exception e){
            logger.info(sdConsumer.getUsername()+"修改失败");
            return actionResult(Code.BAD_REQUEST,"修改失败");
        }

    }

    /**
     * 删除甲方信息接口
     * @param id
     * @Author Luxinli
     * @return
     */
   @RequestMapping(value = "/deleteConsumer",method = RequestMethod.GET)
   @ResponseBody
   @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
   @RequiresAuthentication
    public Object deleteConsumer(int id) {
       try {
           sdConsumerService.deletConsumer(id);
           logger.info("删除成功");
           return actionResult(Code.OK, SysMessage.COMMON_DELETE_SUCCESS);
       } catch (Exception e) {
           e.printStackTrace();
           return actionResult(Code.BAD_REQUEST, "删除失败");
       }
   }
}