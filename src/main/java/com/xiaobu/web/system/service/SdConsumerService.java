package com.xiaobu.web.system.service;

import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.entity.SdManager;

import java.util.List;

/**
* 描述：标注平台用户 服务实现层接口
* @author MuRunSen
* @date 2018-08-08 09:39:32
*/
public interface SdConsumerService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SdConsumer getById(Integer id)throws Exception;

    //SdConsumerDTO createSdConsumer(SdConsumerDTO sdConsumerDTO) throws Exception;
    void add(SdConsumer sdConsumer);

    void delete(Integer id) throws Exception;

    //SdConsumerDTO updateSdConsumer(SdConsumerDTO sdConsumerDTO) throws Exception;
    void update(SdConsumer sdConsumer);

    SdConsumer selectByUsername(String username);

    List<SdConsumer> selectConsumerInfos();
}