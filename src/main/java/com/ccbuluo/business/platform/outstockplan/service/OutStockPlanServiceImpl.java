package com.ccbuluo.business.platform.outstockplan.service;


import com.ccbuluo.business.entity.BizOutstockplanDetail;
import com.ccbuluo.business.platform.outstock.dto.updatePlanStatusDTO;
import com.ccbuluo.business.platform.outstockplan.dao.BizOutstockplanDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ccbuluo.business.platform.outstockplan.dao.BizOutstockplanDetailDao;
import javax.annotation.Resource;

/**
 * 出库计划
 *
 * @author weijb
 * @version v1.0.0
 * @date 2018-08-08 10:45:41
 */
@Service
public class OutStockPlanServiceImpl implements OutStockPlanService {
    @Resource
    BizOutstockplanDetailDao bizOutstockplanDetailDao;
    /**
     *  更改出库计划状态
     * @param applyNo 申请单编号
     * @param planStatus 状态
     * @param outRepositoryNo 出库仓库编号
     * @author weijb
     * @date 2018-08-11 12:55:41
     */
    @Override
    public int updateOutStockPlanStatus(String applyNo, String planStatus, String outRepositoryNo){
        return bizOutstockplanDetailDao.updateOutStockPlanStatus(applyNo, planStatus,outRepositoryNo);
    }

    /**
     * 根据申请单号查询出库计划
     * @param applyNo 申请单号
     * @param outRepositoryNo 出库仓库编号
     * @return 出库计划
     * @author liuduo
     * @date 2018-08-09 14:38:57
     */
    @Override
    public List<BizOutstockplanDetail> queryOutstockplan(String applyNo, String outRepositoryNo) {
        return bizOutstockplanDetailDao.queryOutstockplan(applyNo, outRepositoryNo);
    }

    /**
     * 根据出库计划id查询版本号（乐观锁）
     * @param ids 出库计划id
     * @return 版本号
     * @author liuduo
     * @date 2018-08-10 16:43:38
     */
    @Override
    public List<updatePlanStatusDTO> getVersionNoById(List<Long> ids) {
        return bizOutstockplanDetailDao.getVersionNoById(ids);
    }

    /**
     * 更改出库计划的实际出库数量
     * @param bizOutstockplanDetails 出库计划
     * @author liuduo
     * @date 2018-08-10 16:48:48
     */
    @Override
    public void updateActualOutstocknum(List<BizOutstockplanDetail> bizOutstockplanDetails) {
        bizOutstockplanDetailDao.updateActualOutstocknum(bizOutstockplanDetails);
    }

    /**
     * 更新出库计划中的状态和完成时间
     * @param bizOutstockplanDetails 出库计划
     * @author liuduo
     * @date 2018-08-10 17:46:26
     */
    @Override
    public void updatePlanStatus(List<BizOutstockplanDetail> bizOutstockplanDetails) {
        bizOutstockplanDetailDao.updatePlanStatus(bizOutstockplanDetails);
    }

    /**
     * 根据申请单号查询出库计划
     * @param applyNo 申请单号
     * @param productType 商品类型
     * @return 出库计划
     * @author liuduo
     * @date 2018-08-11 13:17:42
     */
    @Override
    public List<BizOutstockplanDetail> queryOutstockplanList(String applyNo, String productType) {
        return bizOutstockplanDetailDao.queryOutstockplanList(applyNo, productType);
    }
}
