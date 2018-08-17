package com.xiaobu.web.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xiaobu.common.model.PageModel;
import com.xiaobu.web.system.dao.SdConsumerDao;
import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.service.SdConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
* 描述：标注平台用户 服务实现层
* @author MuRunSen
* @date 2018-08-08 09:39:32
*/
@Service("sdConsumerService")
public class SdConsumerServiceImpl implements SdConsumerService {

    @Autowired
    private SdConsumerDao sdConsumerDao;



	public SdConsumer selectByUsername(String username){
        return sdConsumerDao.selectByUsername(username);
    }

    @Override
    public PageModel<SdConsumer> selectConsumerInfos(SdConsumer sdConsumers, PageModel<SdConsumer> page) {
	    System.out.println(page.getStart()+"------------"+page.getLength());
        PageHelper.offsetPage(page.getStart(), page.getLength());
        page.initData(sdConsumerDao.findByPage(sdConsumers));
        return page;
    }


    @Override
    public void insertConsumerInfo(SdConsumer sdConsumer) {
        sdConsumer.setCreatedAt(new Date());
        sdConsumer.setUpdatedAt(new Date());
        sdConsumerDao.insertConsumerInfo(sdConsumer);
    }

    @Override
    public void updateConsumerInfo(SdConsumer sdConsumer) {
        sdConsumerDao.updateNotNull(sdConsumer);
    }

    @Override
    public void deletConsumer(int id) {
        sdConsumerDao.delete(id);
    }
}