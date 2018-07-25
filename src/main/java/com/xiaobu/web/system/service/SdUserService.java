package com.xiaobu.web.system.service;

import com.xiaobu.web.system.entity.SdUser;

public interface SdUserService {

	void insert(SdUser sdUser);

	SdUser selectByname(String nickname);

	SdUser selectByphone(String phone);

}
