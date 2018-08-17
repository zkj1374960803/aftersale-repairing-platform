package com.ccbuluo.business.platform.allocateapply.dao;

import com.ccbuluo.business.constants.Constants;
import com.ccbuluo.business.entity.BizAllocateApply;
import com.ccbuluo.business.platform.allocateapply.dto.*;
import com.ccbuluo.business.platform.stockdetail.dto.StockBizStockDetailDTO;
import com.ccbuluo.dao.BaseDao;
import com.ccbuluo.db.Page;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物料和零配件调拨的申请 dao
 * @author liuduo
 * @date 2018-08-07 11:55:41
 * @version V1.0.0
 */
@Repository
public class ProblemAllocateApplyDao extends BaseDao<AllocateApplyDTO> {
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    return namedParameterJdbcTemplate;
    }

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
    public Page<ProblemAllocateapplyDetailDTO> queryProblemApplyList(String applyType, String applyStatus, String applyNo, Integer offset, Integer pageSize){
        Map<String, Object> param = Maps.newHashMap();
        param.put("deleteFlag", Constants.DELETE_FLAG_NORMAL);
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT id,apply_no,apply_type,apply_status ")
                .append(" FROM biz_allocate_apply  WHERE delete_flag = :deleteFlag ");
        // 申请类型
        if (StringUtils.isNotBlank(applyType)) {
            param.put("applyType", applyType);
            sql.append(" AND apply_type = :applyType ");
        }
        // 申请状态
        if (StringUtils.isNotBlank(applyStatus)) {
            param.put("applyStatus", applyStatus);
            sql.append(" AND apply_status = :applyStatus  ");
        }
        // 商品编号
        if (StringUtils.isNotBlank(applyNo)) {
            param.put("applyNo", applyNo);
            //根据编号或名称查询
            sql.append(" AND apply_no = :applyNo ");
        }

        sql.append(" ORDER BY create_time DESC");
        Page<ProblemAllocateapplyDetailDTO> DTOS = super.queryPageForBean(ProblemAllocateapplyDetailDTO.class, sql.toString(), param,offset,pageSize);
        return DTOS;
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
    public Page<ProblemAllocateapplyDetailDTO> queryProblemHandleList(String applyType, String applyStatus, String applyNo, Integer offset, Integer pageSize){
        Map<String, Object> param = Maps.newHashMap();
        param.put("deleteFlag", Constants.DELETE_FLAG_NORMAL);
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT t1.id,t1.apply_no,t1.apply_type,t1.apply_status ,t2.checked_time as outstock_time,t3.checked_time as instock_time ")
                .append(" FROM biz_allocate_apply t1 LEFT JOIN biz_outstock_order t2 on t1.apply_no=t2.trade_docno ")
                .append(" LEFT JOIN biz_instock_order t3 on t1.apply_no=t3.trade_docno ")
                .append(" WHERE t1.delete_flag = :deleteFlag ");


        // 申请类型
        if (StringUtils.isNotBlank(applyType)) {
            param.put("applyType", applyType);
            sql.append(" AND t1.apply_type = :applyType ");
        }
        // 申请状态
        if (StringUtils.isNotBlank(applyStatus)) {
            param.put("applyStatus", applyStatus);
            sql.append(" AND t1.apply_status = :applyStatus  ");
        }
        // 商品编号
        if (StringUtils.isNotBlank(applyNo)) {
            param.put("applyNo", applyNo);
            //根据编号或名称查询
            sql.append(" AND t1.apply_no = :applyNo ");
        }

        sql.append(" ORDER BY t1.create_time DESC");
        Page<ProblemAllocateapplyDetailDTO> DTOS = super.queryPageForBean(ProblemAllocateapplyDetailDTO.class, sql.toString(), param,offset,pageSize);
        return DTOS;
    }

}
