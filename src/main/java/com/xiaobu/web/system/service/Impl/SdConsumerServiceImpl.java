package com.xiaobu.web.system.service.Impl;
import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.entity.SdManager;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.dao.SdConsumerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
* 描述：标注平台用户 服务实现层
* @author MuRunSen
* @date 2018-08-08 09:39:32
*/
@Service("sdConsumerService")
public class SdConsumerServiceImpl implements SdConsumerService {

    @Autowired
    private SdConsumerDao sdConsumerDao;


    @Override
    public SdConsumer getById(Integer id) throws Exception {
        SdConsumer sdConsumer = sdConsumerDao.getById(id);
        return sdConsumer;
    }

    @Override
    public void add(SdConsumer sdConsumer) {
       sdConsumerDao.add(sdConsumer);
    }

    @Override
    public void update(SdConsumer sdConsumer){
       sdConsumerDao.updateNotNull(sdConsumer);
    }
    
    @Override
	public void delete(Integer id) {

		sdConsumerDao.delete(id);
	}

	public SdConsumer selectByUsername(String username){
        return sdConsumerDao.selectByUsername(username);
    }
}