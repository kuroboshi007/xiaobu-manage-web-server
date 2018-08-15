package com.xiaobu.web.pro.controller;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.common.model.PageModel;
import com.xiaobu.web.pro.service.SdCollectTaskService;
import com.xiaobu.web.pro.entity.SdCollectTask;
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.util.ValidateUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

/**
* 描述：标注平台用户controller
* @author MuRunSen
* @date 2018-08-14 15:47:36
*/
@Controller
@RequestMapping("/sdCollectTask")
public class SdCollectTaskController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SdCollectTaskController.class);

    @Autowired
    private SdCollectTaskService sdCollectTaskService;

    /**
    * 描述：根据Id 查询
    * @param id  标注平台用户id
    */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object findById(@PathVariable("id") Integer id)throws Exception {
        SdCollectTask sdCollectTask = sdCollectTaskService.getById(id);
        
        return actionResult(Code.OK,sdCollectTask);
    }

    /**
    * 描述:创建标注平台用户
    * 保存标注平台用户DTO
    * @param
    */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object create(@RequestBody SdCollectTask sdCollectTask) throws Exception {
    try {
        // 修改
		if(ValidateUtil.isNotEmpty(sdCollectTask.getId())){
			
			sdCollectTaskService.update(sdCollectTask);
		}
		// 新增
			else{
				sdCollectTaskService.add(sdCollectTask);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
        return actionResult(Code.OK);
    }

    /**
    * 描述：删除标注平台用户
    * @param id 标注平台用户id
    */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object deleteById(@PathVariable("id") Integer id) throws Exception {
    try {
        	sdCollectTaskService.delete(id);
    	} catch (Exception e) {
		
		logger.error(e.getMessage(), e);
		return actionResult(Code.OK);
	}
	return actionResult(Code.INTERNAL_SERVER_ERROR);
  }

     @RequestMapping(value = "/selectCollectTaskInfo",method = RequestMethod.POST)
     @ResponseBody
     @RequiresRoles(SysMessage.MANAGER)
    public Object selectCollectTaskInfo(SdCollectTask sdCollectTask, PageModel<SdCollectTask> page){
         try {
             PageModel<SdCollectTask> pages = sdCollectTaskService.selectConsumerInfos(sdCollectTask,page);
             return actionResult(Code.OK,"获取成功",pages);
         } catch (Exception e) {
             e.printStackTrace();
             return actionResult(Code.INTERNAL_SERVER_ERROR,"获取失败");
         }
     }

}