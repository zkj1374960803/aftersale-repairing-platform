package com.ccbuluo.business.platform.inputstockplan.service;


import com.ccbuluo.business.entity.BizInstockplanDetail;
import com.ccbuluo.business.platform.inputstockplan.dao.BizInstockplanDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入库计划
 *
 * @author weijb
 * @version v1.0.0
 * @date 2018-08-08 10:45:41
 */
@Service
public class InputStockPlanServiceImpl implements InputStockPlanService {

    @Autowired
    private BizInstockplanDetailDao bizInstockplanDetailDao;

    /**
     * 根据申请单编号查询入库计划
     * @param applyNo 申请单编号
     * @return 入库计划
     * @author liuduo
     * @date 2018-08-08 11:14:56
     */
    @Override
    public List<BizInstockplanDetail> queryListByApplyNo(String applyNo) {
        return bizInstockplanDetailDao.queryListByApplyNo(applyNo);
    }

    /**
     * 根据入库计划id查询版本号
     * @param instockPlanid 入库计划id
     * @return 版本号
     * @author liuduo
     * @date 2018-08-08 19:31:38
     */
    @Override
    public Integer getVersionNoById(Long instockPlanid) {
        return bizInstockplanDetailDao.getVersionNoById(instockPlanid);
    }

    /**
     * 更新入库佳话中的实际入库数量
     * @param bizInstockplanDetailList 入库计划
     * @author liuduo
     * @date 2018-08-08 20:17:42
     */
    @Override
    public void updateActualInstockNum(List<BizInstockplanDetail> bizInstockplanDetailList) {
        bizInstockplanDetailDao.updateActualInstockNum(bizInstockplanDetailList);
    }
}
