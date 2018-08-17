package com.ccbuluo.business.platform.outstock.dao;

import com.ccbuluo.business.entity.BizOutstockorderDetail;
import com.ccbuluo.business.platform.outstock.dto.OutstockorderDetailDTO;
import com.ccbuluo.dao.BaseDao;
import com.google.common.collect.Maps;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *  出库单详情dao
 * @author liuduo
 * @date 2018-08-07 11:55:41
 * @version V1.0.0
 */
@Repository
public class BizOutstockorderDetailDao extends BaseDao<BizOutstockorderDetail> {
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    return namedParameterJdbcTemplate;
    }

    /**
     * 保存 实体
     * @param entity 实体
     * @return int 影响条数
     * @author liuduo
     * @date 2018-08-07 11:55:41
     */
    public int saveEntity(BizOutstockorderDetail entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO biz_outstockorder_detail ( outstock_orderno,")
            .append("outstock_planid,product_no,product_name,product_type,")
            .append("product_categoryname,supplier_no,outstock_num,unit,cost_price,")
            .append("actual_price,creator,create_time,operator,operate_time,delete_flag,")
            .append("remark ) VALUES (  :outstockOrderno, :outstockPlanid, :productNo,")
            .append(" :productName, :productType, :productCategoryname, :supplierNo,")
            .append(" :outstockNum, :unit, :costPrice, :actualPrice, :creator,")
            .append(" :createTime, :operator, :operateTime, :deleteFlag, :remark )");
        return super.save(sql.toString(), entity);
    }

    /**
     * 编辑 实体
     * @param entity 实体
     * @return 影响条数
     * @author liuduo
     * @date 2018-08-07 11:55:41
     */
    public int update(BizOutstockorderDetail entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE biz_outstockorder_detail SET ")
            .append("outstock_orderno = :outstockOrderno,")
            .append("outstock_planid = :outstockPlanid,product_no = :productNo,")
            .append("product_name = :productName,product_type = :productType,")
            .append("product_categoryname = :productCategoryname,")
            .append("supplier_no = :supplierNo,outstock_num = :outstockNum,unit = :unit,")
            .append("cost_price = :costPrice,actual_price = :actualPrice,")
            .append("creator = :creator,create_time = :createTime,operator = :operator,")
            .append("operate_time = :operateTime,delete_flag = :deleteFlag,")
            .append("remark = :remark WHERE id= :id");
        return super.updateForBean(sql.toString(), entity);
    }

    /**
     * 获取详情
     * @param id  id
     * @author liuduo
     * @date 2018-08-07 11:55:41
     */
    public BizOutstockorderDetail getById(long id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,outstock_orderno,outstock_planid,product_no,product_name,")
            .append("product_type,product_categoryname,supplier_no,outstock_num,unit,")
            .append("cost_price,actual_price,creator,create_time,operator,operate_time,")
            .append("delete_flag,remark FROM biz_outstockorder_detail WHERE id= :id");
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        return super.findForBean(BizOutstockorderDetail.class, sql.toString(), params);
    }

    /**
     * 删除
     * @param id  id
     * @return 影响条数
     * @author liuduo
     * @date 2018-08-07 11:55:41
     */
    public int deleteById(long id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE  FROM biz_outstockorder_detail WHERE id= :id ");
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        return super.updateForMap(sql.toString(), params);
    }

    /**
     * 保存出库单详单
     * @param bizOutstockorderDetailList1 出库单详单
     * @date 2018-08-09 15:58:17
     */
    public List<Long> saveOutstockorderDetail(List<BizOutstockorderDetail> bizOutstockorderDetailList1) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO biz_outstockorder_detail ( outstock_orderno,")
            .append("outstock_planid,product_no,product_name,product_type,")
            .append("product_categoryname,supplier_no,outstock_num,stock_type,unit,cost_price,")
            .append("actual_price,creator,create_time,operator,operate_time,delete_flag,")
            .append("remark ) VALUES (  :outstockOrderno, :outstockPlanid, :productNo,")
            .append(" :productName, :productType, :productCategoryname, :supplierNo,")
            .append(" :outstockNum, :stockType, :unit, :costPrice, :actualPrice, :creator,")
            .append(" :createTime, :operator, :operateTime, :deleteFlag, :remark )");

        return batchInsertForListBean(sql.toString(), bizOutstockorderDetailList1);
    }

    /**
     * 根据申请单号查询出库单详单
     * @param applyNo 申请单号
     * @return 出库单详单
     * @author liuduo
     * @date 2018-08-10 14:16:32
     */
    public List<BizOutstockorderDetail> queryByApplyNo(String applyNo) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("applyNo", applyNo);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,outstock_orderno,outstock_planid,product_no,product_name,")
            .append("product_type,product_categoryname,supplier_no,outstock_num,unit,stock_type,")
            .append("cost_price,actual_price ")
            .append(" FROM biz_outstockorder_detail WHERE outstock_orderno = :applyNo");

        return queryListBean(BizOutstockorderDetail.class, sql.toString(), params);
    }

    /**
     * 根据出库单号查询出库单详单
     * @param outstockNo 出库单号
     * @return 出库单详单
     * @author liuduo
     * @date 2018-08-13 11:26:32
     */
    public List<OutstockorderDetailDTO> queryListByOutstockNo(String outstockNo) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("outstockNo", outstockNo);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT bod.id,bod.outstock_orderno,bod.outstock_planid,bod.product_no,bod.product_name,")
            .append("bod.product_type,bod.product_categoryname,bod.supplier_no,bod.outstock_num,bod.unit,")
            .append("bod.cost_price,bod.actual_price,bodd.out_repository_no,bss.supplier_name FROM biz_outstockorder_detail AS bod ")
            .append(" LEFT JOIN biz_outstockplan_detail AS bodd ON bodd.id = bod.outstock_planid")
            .append(" LEFT JOIN biz_service_supplier AS bss ON bss.supplier_code = bod.supplier_no")
            .append(" WHERE bod.outstock_orderno= :outstockNo");

        return queryListBean(OutstockorderDetailDTO.class, sql.toString(), params);
    }
}
