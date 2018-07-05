package com.mrs.demo.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.demo.web.dao.SysUserDao;
import com.mrs.demo.web.entity.SysUser;
import com.mrs.demo.web.service.SysUserService;

/**
 * 用户管理service实现类
 * 
 * @author Mmmmmm
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysuserdao;
	
	@Override
	public SysUser findByUsername(SysUser sysuser) {
		// TODO Auto-generated method stub
		return sysuserdao.findByUsername(sysuser.getUsername());
	}

}
