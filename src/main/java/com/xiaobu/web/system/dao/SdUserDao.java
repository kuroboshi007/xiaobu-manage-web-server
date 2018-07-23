package com.xiaobu.web.system.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xiaobu.web.system.entity.SdUser;

@Mapper
public interface SdUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SdUser record);

    int insertSelective(SdUser record);

    SdUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SdUser record);

    int updateByPrimaryKey(SdUser record);

	SdUser selectByname(String nickname);
}