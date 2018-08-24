package com.xiaobu.web.system.controller;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.model.PageModel;
import com.xiaobu.common.util.PasswordUtil;
import com.xiaobu.web.system.service.SdOrganizationService;
import com.xiaobu.web.system.entity.SdOrganization;
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

/**
* 描述：标注平台用户controller
* @author MuRunSen
* @date 2018-07-31 11:40:29
*/
@Controller
@RequestMapping("/organization/api/sdOrganization")
public class SdOrganizationController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SdOrganizationController.class);

    @Autowired
    private SdOrganizationService sdOrganizationService;

    /**
     * 团体组织信息List接口
     * @Author Luxinli
     */
    @RequestMapping(value = "/selectOrganizationInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object selectOrganizationInfo(SdOrganization sdOrganization, PageModel<SdOrganization> page){
        try {
            PageModel<SdOrganization> pages = sdOrganizationService.selectOrganizationInfo(sdOrganization,page);
            logger.info("查询成功");
            return actionResult(Code.OK,"获取成功",pages);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("查询失败");
            return actionResult(Code.INTERNAL_SERVER_ERROR,"获取失败");

        }
    }

    /**
     * 新增团体组织信息接口
     * @Author Luxinli
     */
    @RequestMapping(value = "/insertOrganizationInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public  Object insertOrganizationInfo(SdOrganization sdOrganization){
        try {
            //判断账号是否已在数据库存在
            if(sdOrganizationService.selectByUsername(sdOrganization.getUsername()) != null){
                logger.info(sdOrganization.getUsername()+"该用户已存在");
                return actionResult(Code.BAD_REQUEST,"用户名已存在");
            }
            else{
                //对用户密码进行加密
               String encryption_pwd =  PasswordUtil.encryptionPwd(sdOrganization.getPassword());
               sdOrganization.setPassword(encryption_pwd);
                sdOrganizationService.add(sdOrganization);
                logger.info(sdOrganization.getUsername()+"新增成功");
                return actionResult(Code.OK,SysMessage.COMMON_ADD_SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info(sdOrganization.getUsername()+"新增失败");
            return actionResult(Code.INTERNAL_SERVER_ERROR,"新增失败");

        }
    }


    /**
     * 修改团体组织信息接口
     * @Author Luxinli
     */
    @RequestMapping(value = "/updateOrganizationInfo",method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object updateOrganizationInfo(SdOrganization sdOrganization){
        try {
            sdOrganizationService.update(sdOrganization);
            logger.info(sdOrganization.getName()+"修改成功");
            return actionResult(Code.OK,SysMessage.COMMON_UPDATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(sdOrganization.getName()+"修改失败");
            return actionResult(Code.INTERNAL_SERVER_ERROR,"修改失败");
        }
    }

    /**
     * 根据id删除团体组织信息接口
     * @Author Luxinli
     */
    @RequestMapping(value = "/deleteOrganizationInfo",method = RequestMethod.GET)
    @ResponseBody
    @RequiresRoles("Manager")//只有用户类型为manager的用户才可访问
    @RequiresAuthentication
    public Object deleteOrganizationInfo(int id){
        try {
            sdOrganizationService.delete(id);
            logger.info("删除成功");
            return actionResult(Code.OK,SysMessage.COMMON_DELETE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除失败");
            return actionResult(Code.INTERNAL_SERVER_ERROR,"删除失败");
        }
    }


}