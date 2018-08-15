package com.xiaobu.common.config;

/**
 * 任务流程状态值
 */
public enum Dictionarydata {

    /**
     * 已发布
     */
    IS_ISSUE(1),

    /**
     * 已开始
     * @param value
     */
    IS_START(2),

    /**
     * 待检验
     * @param value
     */
    FOR_CHECKOUT(3),

    /**
     * 检验失败
     * @param value
     */
    CHECKOUT_ERROR(4),

    /**
     * 检验成功
     * @param value
     */
    CHECKOUT_PASS(5),

    /**
     * 待审核
     * @param value
     */
    FOR_INSPECTION(6),

    /**
     * 审核失败
     * @param value
     */
    INSPECTION_ERROR(7),

    /**
     * 审核成功
     * @param value
     */
    INSPECTION_PASS(8),

    /**
     * 已满额
     */
    FULFIL_QUOTA(9),

    /**
     * 待验收
     * @param value
     */
    FOR_ACCEPTANCE(10),

    /**
     * 验收失败
     * @param value
     */
    ACCEPTANCE_ERROR(11),

    /**
     * 验收成功
     * @param value
     */
    ACCEPTANCE_SUCCESS(12),

    /**
     *已完结
     * @param value
     */
    IS_FINISH(13),

    /**
     * 已结算
     * @param value
     */
    IS_CLOSE_ACCOUNT(14),

    /**
     * 废弃
     * @param value
     */
    DISCARD(15);


    private final Integer value;
    private Dictionarydata(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }


    public String toString() {
        return this.value.toString();
    }
}
