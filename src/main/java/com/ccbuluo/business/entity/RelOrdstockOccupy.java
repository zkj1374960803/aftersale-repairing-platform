package com.ccbuluo.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单占用库存关系实体
 *
 * @author weijb
 * @version v1.0.0
 * @date 2018-08-08 20:21:24
 */
@ApiModel(value = "RelOrdstockOccupy", description = "订单占用库存关系实体")
public class RelOrdstockOccupy extends AftersaleCommonEntity{
    /**
     * 交易类型
     */
    @ApiModelProperty(name = "orderType", value = "采购或是调拨")
    private String orderType;
    /**
     * 申请单code
     */
    @ApiModelProperty(name = "docNo", value = "申请单code")
    private String docNo;
    /**
     * 占用批次库存id
     */
    @ApiModelProperty(name = "stockId", value = "占用批次库存id")
    private Long stockId;
    /**
     * 占用商品的数量
     */
    @ApiModelProperty(name = "occupyNum", value = "占用商品的数量")
    private Long occupyNum;
    /**
     * 状态（占用中、撤销占用、售出）
     */
    @ApiModelProperty(name = "occupyStatus", value = "状态（占用中、撤销占用、售出）")
    private String occupyStatus;
    /**
     * 开始占用该库存的时间
     */
    @ApiModelProperty(name = "occupyStarttime", value = "开始占用该库存的时间")
    private Date occupyStarttime;
    /**
     * 结束占用该库存的时间
     */
    @ApiModelProperty(name = "occupyEndtime", value = "结束占用该库存的时间")
    private Date occupyEndtime;
    /**
     * 买方机构的编号
     */
    @ApiModelProperty(name = "instockOrgno", value = "买方机构的编号", hidden = true)
    private String instockOrgno;
    /**
     * 卖方机构的编号
     */
    @ApiModelProperty(name = "outstockOrgno", value = "卖方机构的编号", hidden = true)
    private String outstockOrgno;
    /**
     *  库存类型
     */
    @ApiModelProperty(name = "stockType", value = "库存类型（正常库存、问题库存、报损件库存，等等）")
    private String stockType;

    /**
     * 供应商
     */
    @ApiModelProperty(name = "supplierNo", value = "")
    private String supplierNo;
    /**
     * 成本价
     */
    @ApiModelProperty(name = "costPrice", value = "")
    private BigDecimal costPrice;

    /**
     * 商品编号
     */
    @ApiModelProperty(name = "productNo", value = "商品编号")
    private String productNo;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getOccupyNum() {
        return occupyNum;
    }

    public void setOccupyNum(Long occupyNum) {
        this.occupyNum = occupyNum;
    }

    public String getOccupyStatus() {
        return occupyStatus;
    }

    public void setOccupyStatus(String occupyStatus) {
        this.occupyStatus = occupyStatus;
    }

    public Date getOccupyStarttime() {
        return occupyStarttime;
    }

    public void setOccupyStarttime(Date occupyStarttime) {
        this.occupyStarttime = occupyStarttime;
    }

    public Date getOccupyEndtime() {
        return occupyEndtime;
    }

    public void setOccupyEndtime(Date occupyEndtime) {
        this.occupyEndtime = occupyEndtime;
    }

    public String getInstockOrgno() {
        return instockOrgno;
    }

    public void setInstockOrgno(String instockOrgno) {
        this.instockOrgno = instockOrgno;
    }

    public String getOutstockOrgno() {
        return outstockOrgno;
    }

    public void setOutstockOrgno(String outstockOrgno) {
        this.outstockOrgno = outstockOrgno;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
}
