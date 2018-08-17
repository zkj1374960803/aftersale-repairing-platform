package com.ccbuluo.business.platform.allocateapply.service;

import com.ccbuluo.business.platform.allocateapply.dao.ProblemAllocateApplyDao;
import com.ccbuluo.business.platform.allocateapply.dto.ProblemAllocateapplyDetailDTO;
import com.ccbuluo.business.platform.stockdetail.dto.StockBizStockDetailDTO;
import com.ccbuluo.db.Page;
import com.ccbuluo.merchandiseintf.carparts.parts.dto.BasicCarpartsProductDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述（1）
 *
 * @author weijb
 * @version v1.0.0
 * @date 创建时间（2）
 */
@Service
public class ProblemAllocateApplyImpl implements ProblemAllocateApply {

    @Resource
    private ProblemAllocateApplyDao problemAllocateApplyDao;

    /**
     * 问题件申请列表
     * @param applyType 申请类型
     * @param applyStatus 申请状态
     * @param applyNo 申请单号
     * @param offset 起始数
     * @param pageSize 每页数量
     * @author weijb
     * @date 2018-08-14 21:59:51
     */
    @Override
    public Page<ProblemAllocateapplyDetailDTO> queryProblemApplyList(String applyType, String applyStatus, String applyNo, Integer offset, Integer pageSize){
        return problemAllocateApplyDao.queryProblemApplyList(applyType, applyStatus, applyNo, offset, pageSize);
    }
    /**
     * 问题件处理列表
     * @param applyType 申请类型
     * @param applyStatus 申请状态
     * @param applyNo 申请单号
     * @param offset 起始数
     * @param pageSize 每页数量
     * @author weijb
     * @date 2018-08-15 18:51:51
     */
    @Override
    public Page<ProblemAllocateapplyDetailDTO> queryProblemHandleList(String applyType, String applyStatus, String applyNo, Integer offset, Integer pageSize){
        return problemAllocateApplyDao.queryProblemHandleList(applyType, applyStatus, applyNo, offset, pageSize);
    }

}
