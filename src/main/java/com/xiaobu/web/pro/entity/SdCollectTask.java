package com.xiaobu.web.pro.entity;
import java.io.Serializable;

import com.xiaobu.common.base.BaseEntity;

/**
* 描述：标注平台用户模型
* @author MuRunSen
* @date 2018-08-14 15:47:36
*/

public class SdCollectTask extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
    /**
    *ID
    */
    /**
    *父任务ID
    */
    private Integer parentId;

    /**
    *甲方ID
    */
    private Integer consumerId;

    /**
    *组织ID
    */
    private Integer organizationId;

    /**
    *任务名称
    */
    private String name;

    /**
    *简介
    */
    private String intro;

    /**
    *详细说明
    */
    private String detail;

    /**
    *主分类
    */
    //private Integer categroy;

    /**
    *自分类
    */
    private Integer type;

    /**
    *示例
    */
    private String example;

    /**
    *甲方总价
    */
    /**
    *单价
    */
    /**
    *操作期限
    */
    private Integer duration;

    /**
    *交付甲方的时间
    */
    private String promiseTime;

    /**
    *采集期限
    */
    /**
    *总数量
    */
    private Integer count;

    /**
    *完成数量
    */
    private Integer doneNum;

    /**
    *状态
    */
    private Integer status;

    /**
    *任务开始时间
    */

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getConsumerId() {
        return this.consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /*public Integer getCategroy() {
        return this.categroy;
    }

    public void setCategroy(Integer categroy) {
        this.categroy = categroy;
    }*/

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExample() {
        return this.example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPromiseTime() {
        return this.promiseTime;
    }

    public void setPromiseTime(String promiseTime) {
        this.promiseTime = promiseTime;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDoneNum() {
        return this.doneNum;
    }

    public void setDoneNum(Integer doneNum) {
        this.doneNum = doneNum;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}