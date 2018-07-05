package com.mrs.demo.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrs.demo.web.entity.SysUser;

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
