package com.mrs.demo.web.service;

import com.mrs.demo.web.entity.SysUser;

/**
 * 用户管理service接口
 * 
 * @author Mmmmm
 *
 */
public interface SysUserService {

	SysUser findByUsername(SysUser sysuser);

}
