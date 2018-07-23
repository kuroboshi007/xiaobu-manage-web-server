package com.xiaobu.web.system.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xiaobu.common.base.BaseDao;
import com.xiaobu.web.system.entity.SysUser;

/**
 * 用户管理dao接口
 * 
 * @author Mmmmm
 *
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUser, String>{

	SysUser findByUsername(String username);

	

}
