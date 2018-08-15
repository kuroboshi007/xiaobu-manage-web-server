package com.xiaobu.web.system.service.Impl;
import com.github.pagehelper.PageHelper;
import com.xiaobu.common.model.PageModel;

import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.dao.SdConsumerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




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

    @Override
    public PageModel<SdConsumer> selectConsumerInfos(SdConsumer sdConsumers, PageModel<SdConsumer> page) {
        PageHelper.offsetPage(page.getStart(), page.getLength());
        page.initData(sdConsumerDao.findByPage(sdConsumers));
        return page;
    }

}