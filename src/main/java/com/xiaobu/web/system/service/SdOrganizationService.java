package com.xiaobu.web.system.service;

import com.xiaobu.web.system.entity.SdOrganization;
/**
* 描述：标注平台用户 服务实现层接口
* @author MuRunSen
* @date 2018-07-31 11:40:29
*/
public interface SdOrganizationService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SdOrganization getById(Integer id)throws Exception;

    //SdOrganizationDTO createSdOrganization(SdOrganizationDTO sdOrganizationDTO) throws Exception;
    void add(SdOrganization sdOrganization);

    void delete(Integer id) throws Exception;

    //SdOrganizationDTO updateSdOrganization(SdOrganizationDTO sdOrganizationDTO) throws Exception;
    void update(SdOrganization sdOrganization);

	SdOrganization selectByUsername(String username);

	void insertAndGetId(SdOrganization sdOrganization);

}