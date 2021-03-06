package com.ccbuluo.business.platform.order.service.fifohandle;

import com.ccbuluo.business.platform.inputstockplan.dao.BizInstockplanDetailDao;
import com.ccbuluo.http.StatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 调拨出入库回调
 *
 * @author weijb
 * @version v1.0.0
 * @date 2018-09-13 16:41:55
 */
@Service
public class SameLevelStockInOutCallBack implements StockInOutCallBack{
    @Autowired
    private BizInstockplanDetailDao bizInstockplanDetailDao;
    @Autowired
    InOutCallBackService inOutCallBackService;

    @Override
    public StatusDto inStockCallBack(String docNo,String inRepositoryNo) {
        // 更改申请单状态
        inOutCallBackService.updateApplyStatus(docNo,inRepositoryNo);
        return StatusDto.buildSuccessStatusDto("操作成功！");
    }

    @Override
    public StatusDto outStockCallBack(String docNo,String outRepositoryNo) {
        inOutCallBackService.updateApplyOrderStatus(docNo,outRepositoryNo);
        // 卖方出库之后要更改申请方入库计划状态
        bizInstockplanDetailDao.updateCompleteStatus(docNo);
        return StatusDto.buildSuccessStatusDto("操作成功！");
    }

}
