package com.xiaobu.web.system.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaobu.web.system.dao.SdUserDao;
import com.xiaobu.web.system.entity.SdUser;
import com.xiaobu.web.system.service.SdUserService;

@Service("sdUserService")
public class SdUserServiceImpl implements SdUserService{

	@Autowired
	private SdUserDao sdUserDao;
	
	@Override
	public void insert(SdUser sdUser) {
		// TODO Auto-generated method stub
		sdUser.setCreatedAt(new Date());
		sdUser.setUpdatedAt(new Date());
		sdUserDao.insert(sdUser);
	}

	@Override
	public SdUser selectByname(String nickname) {
		// TODO Auto-generated method stub
		return sdUserDao.selectByname(nickname);
	}

	@Override
	public SdUser selectByphone(String phone) {
		// TODO Auto-generated method stub
		return sdUserDao.selectByphone(phone);
	}

}
