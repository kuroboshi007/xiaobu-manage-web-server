package com.xiaobu.web.system.controller;
import com.xiaobu.web.system.service.SdManagerService;
import com.xiaobu.web.system.entity.SdManager;
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.util.ValidateUtil;
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
* @date 2018-07-31 11:56:39
*/
@Controller
@RequestMapping("/sdManager")
public class SdManagerController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SdManagerController.class);

    @Autowired
    private SdManagerService sdManagerService;

    /**
    * 描述：根据Id 查询
    * @param id  标注平台用户id
    */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object findById(@PathVariable("id") Integer id)throws Exception {
        SdManager sdManager = sdManagerService.getById(id);
        
        return actionResult(Code.OK,sdManager);
    }

    /**
    * 描述:创建标注平台用户
    * 保存
    * @param sdManagerDTO  标注平台用户DTO
    */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object create(@RequestBody SdManager sdManager) throws Exception {
    try {
        // 修改
		if(ValidateUtil.isNotEmpty(sdManager.getId())){
			
			sdManagerService.update(sdManager);
		}
		// 新增
			else{
				sdManagerService.add(sdManager);
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
        	sdManagerService.delete(id);
    	} catch (Exception e) {
		
		logger.error(e.getMessage(), e);
		return actionResult(Code.OK);
	}
	return actionResult(Code.INTERNAL_SERVER_ERROR);
  }
}