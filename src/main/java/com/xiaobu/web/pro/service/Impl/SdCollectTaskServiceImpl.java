package com.xiaobu.web.pro.service.Impl;
import com.github.pagehelper.PageHelper;
import com.xiaobu.common.model.PageModel;
import com.xiaobu.web.pro.entity.SdCollectTask;
import com.xiaobu.web.pro.service.SdCollectTaskService;
import com.xiaobu.web.pro.dao.SdCollectTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
* 描述：标注平台用户 服务实现层
* @author MuRunSen
* @date 2018-08-14 15:47:36
*/
@Service("sdCollectTaskService")
public class SdCollectTaskServiceImpl implements SdCollectTaskService {

    @Autowired
    private SdCollectTaskDao sdCollectTaskDao;


    @Override
    public SdCollectTask getById(Integer id) throws Exception {
        SdCollectTask sdCollectTask = sdCollectTaskDao.getById(id);
        return sdCollectTask;
    }

    @Override
    public void add(SdCollectTask sdCollectTask) {
       sdCollectTaskDao.add(sdCollectTask);
    }

    @Override
    public void update(SdCollectTask sdCollectTask){
       sdCollectTaskDao.updateNotNull(sdCollectTask);
    }

    @Override
    public PageModel<SdCollectTask> selectConsumerInfos(SdCollectTask sdCollectTask, PageModel<SdCollectTask> page) {
        PageHelper.offsetPage(page.getStart(), page.getLength());
        page.initData(sdCollectTaskDao.findByPage(sdCollectTask));
        return page;
    }

    @Override
	public void delete(Integer id) {

		sdCollectTaskDao.delete(id);
	}
}