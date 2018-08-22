package com.ccbuluo.business.platform.order.controller;

import com.ccbuluo.business.platform.allocateapply.dto.FindAllocateApplyDTO;
import com.ccbuluo.business.platform.order.service.PaymentService;
import com.ccbuluo.http.StatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  支付功能
 *
 * @author weijb
 * @version v1.0.0
 * @date 2018-08-22 16:33:00
 */
@Api(tags = "支付功能")
@RestController
@RequestMapping("/platform/payment")
public class PaymentController {
    @Resource
    PaymentService paymentService;
    /**
     *  支付完成调用接口
     * @param applyNo 申请单号
     * @return StatusDto
     * @author weijb
     * @date 2018-08-22 17:02:58
     */
    @ApiOperation(value = "查询退换货申请单详情", notes = "【魏俊标】")
    @GetMapping("/paymentcompletion/{applyNo}")
    @ApiImplicitParam(name = "applyNo", value = "申请单号", required = true, paramType = "path")
    public StatusDto<FindAllocateApplyDTO> paymentCompletion(@PathVariable String applyNo){
        return paymentService.paymentCompletion(applyNo);
    }
}
