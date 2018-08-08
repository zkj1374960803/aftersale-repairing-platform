package com.ccbuluo.business.platform.allocateapply.service;

import com.ccbuluo.business.platform.allocateapply.entity.BizAllocateApply;

/**
 * @author zhangkangjian
 * @date 2018-08-07 14:29:38
 */
public interface AllocateApply {
    /**
     * 创建物料或者零配件申请
     * @param bizAllocateApply 申请单实体
     * @author zhangkangjian
     * @date 2018-08-07 20:54:24
     */
    void createAllocateApply(BizAllocateApply bizAllocateApply);
}
