package com.xiaobu.web.system.service.Impl;

import com.xiaobu.web.system.dao.SysUserDao;
import com.xiaobu.web.system.entity.SysUser;
import com.xiaobu.web.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理service实现类
 * 
 * @author Mmmmmm
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysuserdao;
	
	@Override
	public SysUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return sysuserdao.findByUsername(username);
	}

	@Override
	public void add(SysUser sysuer) {
		// TODO Auto-generated method stub
		sysuserdao.add(sysuer);
	}

}
