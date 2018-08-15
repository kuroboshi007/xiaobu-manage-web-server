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
     * 已满额
     */
    FULFIL_QUOTA(2),

    /**
     * 待验收
     * @param value
     */
    FOR_ACCEPTANCE(3),

    /**
     * 验收失败
     * @param value
     */
    ACCEPTANCE_ERROR(4),

    /**
     *已完结
     * @param value
     */
    IS_FINISH(5),

    /**
     * 废弃
     * @param value
     */
    DISCARD(6),

    /**
     * 已开始
     * @param value
     */
    IS_START(7),

    /**
     * 待审核
     * @param value
     */
    FOR_INSPECTION(8),

    /**
     * 审核失败
     * @param value
     */
    INSPECTION_ERROR(9),

    /**
     * 审核通过
     * @param value
     */
    INSPECTION_PASS(10),

    /**
     * 已结算
     * @param value
     */
    IS_CLOSE_ACCOUNT(11),

    /**
     * 待检验
     * @param value
     */
    FOR_CHECKOUT(12),

    /**
     * 检验失败
     * @param value
     */
    CHECKOUT_ERROR(13),

    /**
     * 检验通过
     * @param value
     */
    CHECKOUT_PASS(14),

    /**
     * 验收成功
     * @param value
     */
    ACCEPTANCE_SUCCESS(15);

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
