package com.xiaobu.web.pro.service;

import com.xiaobu.common.model.PageModel;
import com.xiaobu.web.pro.entity.SdCollectTask;
/**
* 描述：标注平台用户 服务实现层接口
* @author MuRunSen
* @date 2018-08-14 15:47:36
*/
public interface SdCollectTaskService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SdCollectTask getById(Integer id)throws Exception;

    //SdCollectTaskDTO createSdCollectTask(SdCollectTaskDTO sdCollectTaskDTO) throws Exception;
    void add(SdCollectTask sdCollectTask);

    void delete(Integer id) throws Exception;

    //SdCollectTaskDTO updateSdCollectTask(SdCollectTaskDTO sdCollectTaskDTO) throws Exception;
    void update(SdCollectTask sdCollectTask);

    PageModel<SdCollectTask> selectConsumerInfos(SdCollectTask sdCollectTask, PageModel<SdCollectTask> page);
}