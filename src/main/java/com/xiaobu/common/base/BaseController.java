package com.xiaobu.common.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SessionAttr;
import com.xiaobu.common.util.ContextHolderUtil;
import com.xiaobu.common.util.DateConvertEditor;
import com.xiaobu.web.system.entity.SysUser;


/**
 * 基础controller
 * 
 * @author Mmmmm
 *
 */
public class BaseController {

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {

		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
	
	/**
	 * 抽取由逗号分隔的主键列表
	 * @param ids
	 * @return
	 */
	protected List<String> extractIdListByComma(String ids) {
        List<String> result = new ArrayList<String>();
        if (StringUtils.hasText(ids)) {
            for (String id : ids.split(",")) {
                if (StringUtils.hasLength(id)) {
                    result.add(id.trim());
                }
            }
        }

        return result;
    }
	
	/**
	 * 获取登录的当前用户信息
	 * @return
	 */
	public SysUser getCurrentUser(){
		
		HttpSession session = ContextHolderUtil.getSession();
		SysUser user = (SysUser)session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		
		return user;
	}
	
	/** 把 ,连接的字符串 转化为 int[]数组
	 * */
	protected int[] str2Arr(String delitems){
		delitems=delitems.trim();
		String[] idStrArr = delitems.split(",");
		
		int[] idArr=new int[idStrArr.length];
		
		for (int i=0;i<idStrArr.length;i++) {
			idArr[i]=Integer.parseInt(idStrArr[i]);
		}
		return idArr;
	}
	
	/** 设置响应代码 */
	protected Object actionResult(Code code){
		return actionResult(code,null);
	}
	
	/** 设置响应代码 
	 * */
	protected Object actionResult(Code code, Object data){
		Map<String, Object> map = new HashMap<String, Object>();
		if (data != null) {
			map.put("result", data);
		}
		map.put("code", code.value());
		map.put("message", code.message());
		map.put("timestamp", System.currentTimeMillis());
		return map;
	}
}
