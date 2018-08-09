package com.ccbuluo.business.platform.allocateapply.dto;

import com.ccbuluo.business.platform.allocateapply.entity.BizAllocateapplyDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 查询申请单详情
 * @author zhangkangjian
 * @date 2018-05-10 11:43:11
 * @version V1.0.0
 */
@ApiModel(value = "FindAllocateApplyDTO", description = "查询申请单详情")
public class FindAllocateApplyDTO {

    /**
     * 申请单的编号
     */
    @ApiModelProperty(name = "applyNo", value = "申请单的编号", hidden = true)
    private String applyNo;

    /**
     * 待处理、申请撤销、等待付款、等待发货、（平台待出入库只用在平台端）、等待收货、确认收货、申请完成
     */
    @ApiModelProperty(name = "applyStatus", value = "10待处理、15申请撤销、20等待付款、30等待发货、40（平台待出入库只用在平台端）、50等待收货、60确认收货、70申请完成")
    private String applyStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;
    /**
     * 申请人的uuid
     */
    @ApiModelProperty(name = "applyerName", value = "申请人姓名")
    private String applyerName;

    /**
     * 平台决定的处理类型：调拨、采购
     */
    @ApiModelProperty(name = "processType", value = "平台决定的处理类型(注：TRANSFER调拨、PURCHASE采购)")
    private String processType;

    /**
     * 出库的组织架构
     */
    @ApiModelProperty(name = "outstockOrgno", value = "出库的组织架构(采购类型时，不必填)")
    private String outstockOrgno;
    /**
     * 出库的组织架构
     */
    @ApiModelProperty(name = "outstockOrgName", value = "出库的组织架构名称")
    private String outstockOrgName;
    /**
     * 入库组织架构
     */
    @ApiModelProperty(name = "instockOrgno", value = "入库组织架构(采购类型时，不必填)")
    private String instockOrgno;
    /**
     * 入库仓库编号
     */
    @ApiModelProperty(name = "inRepositoryNo", value = "入库仓库编号")
    private String inRepositoryNo;
    /**
     * 入库组织架构
     */
    @ApiModelProperty(name = "instockOrgName", value = "入库的组织架构名称")
    private String instockOrgName;
    /**
     * 仓库名称
     */
    @ApiModelProperty(name = "storehouseName", value = "仓库名称")
    private String storehouseName;
    /**
     * 仓库地址
     */
    @ApiModelProperty(name = "storehouseAddress", value = "仓库地址")
    private String storehouseAddress;


    /**
     * 申请商品详情列表
     */
    @ApiModelProperty(name = "ueryAllocateapplyDetailDTO", value = "申请商品详情列表")
    private List<QueryAllocateapplyDetailDTO> queryAllocateapplyDetailDTO;

    public List<QueryAllocateapplyDetailDTO> getQueryAllocateapplyDetailDTO() {
        return queryAllocateapplyDetailDTO;
    }

    public void setQueryAllocateapplyDetailDTO(List<QueryAllocateapplyDetailDTO> queryAllocateapplyDetailDTO) {
        this.queryAllocateapplyDetailDTO = queryAllocateapplyDetailDTO;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    public String getInRepositoryNo() {
        return inRepositoryNo;
    }

    public void setInRepositoryNo(String inRepositoryNo) {
        this.inRepositoryNo = inRepositoryNo;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getOutstockOrgno() {
        return outstockOrgno;
    }

    public void setOutstockOrgno(String outstockOrgno) {
        this.outstockOrgno = outstockOrgno;
    }

    public String getOutstockOrgName() {
        return outstockOrgName;
    }

    public void setOutstockOrgName(String outstockOrgName) {
        this.outstockOrgName = outstockOrgName;
    }

    public String getInstockOrgno() {
        return instockOrgno;
    }

    public void setInstockOrgno(String instockOrgno) {
        this.instockOrgno = instockOrgno;
    }

    public String getInstockOrgName() {
        return instockOrgName;
    }

    public void setInstockOrgName(String instockOrgName) {
        this.instockOrgName = instockOrgName;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }

    public String getStorehouseAddress() {
        return storehouseAddress;
    }

    public void setStorehouseAddress(String storehouseAddress) {
        this.storehouseAddress = storehouseAddress;
    }
}