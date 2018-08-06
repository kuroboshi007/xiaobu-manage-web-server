package com.xiaobu.web.system.dao;
import org.apache.ibatis.annotations.Mapper;

import com.xiaobu.common.base.BaseDao;
import com.xiaobu.web.system.entity.SdOrganization;

/**
* 描述：标注平台用户DTO
* @author MuRunSen
* @date 2018-07-31 11:40:29
*/
@Mapper
public interface SdOrganizationDao extends BaseDao<SdOrganization, Integer>{

	SdOrganization selectByUsername(String username);

	void insertAndGetId(SdOrganization sdOrganization);

}