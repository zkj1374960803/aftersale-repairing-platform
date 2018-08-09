package com.ccbuluo.business.platform.instock.dto;

import com.ccbuluo.business.entity.AftersaleCommonEntity;
import com.ccbuluo.business.entity.BizInstockorderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 入库单实体
 * @author liuduo
 * @date 2018-05-10 11:43:11
 * @version V1.0.0
 */
@ApiModel(value = "入库单实体", description = "入库单实体")
public class SaveBizInstockOrderDTO extends AftersaleCommonEntity{
    /**
     * 入库单编号
     */
    @ApiModelProperty(name = "instockOrderno", value = "入库单编号")
    private String instockOrderno;
    /**
     * 可以使申请调拨单或其他类型可以出发入库的单据
     */
    @ApiModelProperty(name = "tradeDocno", value = "可以使申请调拨单或其他类型可以出发入库的单据")
    private String tradeDocno;
    /**
     * 要入货的仓库编号
     */
    @ApiModelProperty(name = "inRepositoryNo", value = "要入货的仓库编号")
    private String inRepositoryNo;
    /**
     * 入库单所属机构
     */
    @ApiModelProperty(name = "instockOrgno", value = "入库单所属机构")
    private String instockOrgno;
    /**
     * 入库人的uuid
     */
    @ApiModelProperty(name = "instockOperator", value = "入库人的uuid")
    private String instockOperator;
    /**
     * 入库类型
     */
    @ApiModelProperty(name = "instockType", value = "入库类型")
    private String instockType;
    /**
     * 入库时间
     */
    @ApiModelProperty(name = "instockTime", value = "入库时间")
    private Date instockTime;
    /**
     * 物流单号
     */
    @ApiModelProperty(name = "transportorderNo", value = "物流单号")
    private String transportorderNo;
    /**
     * 复核完成
     */
    @ApiModelProperty(name = "checked", value = "复核完成")
    private String checked;
    /**
     * 复核完成时间
     */
    @ApiModelProperty(name = "ceeckedTime", value = "复核完成时间")
    private Date ceeckedTime;

    /**
     * 入库单详情
     */
    @ApiModelProperty(name = "instockorderDetailList", value = "入库单详情")
    private List<BizInstockorderDetail> instockorderDetailList;


    public void setInstockOrderno(String instockOrderno) {
        this.instockOrderno = instockOrderno;
    }

    public String getInstockOrderno() {
        return this.instockOrderno;
    }

    public void setTradeDocno(String tradeDocno) {
        this.tradeDocno = tradeDocno;
    }

    public String getTradeDocno() {
        return this.tradeDocno;
    }

    public void setInRepositoryNo(String inRepositoryNo) {
        this.inRepositoryNo = inRepositoryNo;
    }

    public String getInRepositoryNo() {
        return this.inRepositoryNo;
    }

    public void setInstockOperator(String instockOperator) {
        this.instockOperator = instockOperator;
    }

    public String getInstockOperator() {
        return this.instockOperator;
    }

    public void setInstockType(String instockType) {
        this.instockType = instockType;
    }

    public String getInstockType() {
        return this.instockType;
    }

    public void setInstockTime(Date instockTime) {
        this.instockTime = instockTime;
    }

    public Date getInstockTime() {
        return this.instockTime;
    }

    public void setTransportorderNo(String transportorderNo) {
        this.transportorderNo = transportorderNo;
    }

    public String getTransportorderNo() {
        return this.transportorderNo;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getChecked() {
        return this.checked;
    }

    public void setCeeckedTime(Date ceeckedTime) {
        this.ceeckedTime = ceeckedTime;
    }

    public Date getCeeckedTime() {
        return this.ceeckedTime;
    }

    public String getInstockOrgno() {
        return instockOrgno;
    }

    public void setInstockOrgno(String instockOrgno) {
        this.instockOrgno = instockOrgno;
    }

    public List<BizInstockorderDetail> getInstockorderDetailList() {
        return instockorderDetailList;
    }

    public void setInstockorderDetailList(List<BizInstockorderDetail> instockorderDetailList) {
        this.instockorderDetailList = instockorderDetailList;
    }
}