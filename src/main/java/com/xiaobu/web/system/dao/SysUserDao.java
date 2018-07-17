package com.xiaobu.web.system.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xiaobu.web.system.entity.SysUser;

/**
 * 用户管理dao接口
 * 
 * @author Mmmmm
 *
 */
@Mapper
public interface SysUserDao {

	SysUser findByUsername(String username);

}
