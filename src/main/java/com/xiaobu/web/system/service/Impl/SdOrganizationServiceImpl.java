package com.xiaobu.web.system.service.Impl;
import com.xiaobu.web.system.entity.SdOrganization;
import com.xiaobu.web.system.service.SdOrganizationService;
import com.xiaobu.web.system.dao.SdOrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

/**
* 描述：标注平台用户 服务实现层
* @author MuRunSen
* @date 2018-07-31 11:40:29
*/
@Service("sdOrganizationService")
public class SdOrganizationServiceImpl implements SdOrganizationService {

    @Autowired
    private SdOrganizationDao sdOrganizationDao;


    @Override
    public SdOrganization getById(Integer id) throws Exception {
        SdOrganization sdOrganization = sdOrganizationDao.getById(id);
        return sdOrganization;
    }

    @Override
    public void add(SdOrganization sdOrganization) {
       sdOrganizationDao.add(sdOrganization);
    }

    @Override
    public void update(SdOrganization sdOrganization){
       sdOrganizationDao.updateNotNull(sdOrganization);
    }
    
    @Override
	public void delete(Integer id) {

		sdOrganizationDao.delete(id);
	}

	@Override
	public SdOrganization selectByUsername(String username) {
		return sdOrganizationDao.selectByUsername(username);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void insertAndGetId(SdOrganization sdOrganization) {
		
		try {
			sdOrganization.setCreatedAt(new Date());
			sdOrganization.setUpdatedAt(new Date());
			sdOrganizationDao.insertAndGetId(sdOrganization);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("注册失败");
		}
	}
}