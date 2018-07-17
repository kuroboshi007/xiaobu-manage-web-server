package com.xiaobu.web.system.service;

import com.xiaobu.web.system.entity.SysUser;

/**
 * 用户管理service接口
 * 
 * @author Mmmmm
 *
 */
public interface SysUserService {

	SysUser findByUsername(String username);

}
