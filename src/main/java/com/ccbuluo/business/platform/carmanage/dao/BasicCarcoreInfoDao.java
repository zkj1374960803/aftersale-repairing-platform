package com.ccbuluo.business.platform.carmanage.dao;

import com.ccbuluo.business.constants.Constants;
import com.ccbuluo.business.platform.carconfiguration.entity.CarcoreInfo;
import com.ccbuluo.business.platform.carmanage.dto.*;
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
 * 车辆基本信息dao
 * @author chaoshuai
 * @date 2018-05-08 10:45:01
 */
@Repository
public class BasicCarcoreInfoDao extends BaseDao<CarcoreInfo> {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }


    /**
     * 新增车辆基本信息
     * @param entity 车辆基本信息
     * @return long
     * @exception
     * @author wuyibo
     * @date 2018-05-09 18:41:36
     */
    public long saveCarcoreInfo(CarcoreInfo entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO basic_carcore_info ( car_number,vin_number,engine_number,")
                .append("beidou_number,carbrand_id,carseries_id,carmodel_id,produce_time,")
                .append("remark,car_status, creator,create_time,operator,operate_time,delete_flag")
                .append(" ) VALUES (  :carNumber, :vinNumber, :engineNumber, :beidouNumber,")
                .append(" :carbrandId, :carseriesId, :carmodelId, :produceTime, :remark, :carStatus,")
                .append(" :creator, :createTime, :operator, :operateTime, :deleteFlag )");
        return super.save(sql.toString(), entity);
    }

    /**
     * 编辑 实体
     * @param entity 实体
     * @return 影响条数
     * @author weijb
     * @date 2018-07-13 17:29:31
     */
    public int updateCarcoreInfo(CarcoreInfo entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE basic_carcore_info ")
                .append("SET vin_number = :vinNumber,engine_number = :engineNumber,")
                .append("beidou_number = :beidouNumber,carbrand_id = :carbrandId,")
                .append("carseries_id = :carseriesId,carmodel_id = :carmodelId,")
                .append("produce_time = :produceTime,remark = :remark,operator = :operator,")
                .append("operate_time = :operateTime WHERE id= :id");
        return super.updateForBean(sql.toString(), entity);
    }

    /**
     * 车辆基本信息 车牌号 是否存在
     * @param carcoreInfo 车辆基本信息
     * @return int
     * @exception
     * @author wuyibo
     * @date 2018-05-09 18:41:36
     */
    public int countPlateNumber(CarcoreInfo carcoreInfo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM basic_carcore_info ")
            .append("   WHERE plate_number = :plateNumber AND delete_flag = :deleteFlag");
        if (null != carcoreInfo.getId()) {
            sql.append(" AND id != :id");
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("deleteFlag", carcoreInfo.getDeleteFlag());
        params.put("id", carcoreInfo.getId());
        return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
    }

    /**
     * 车辆基本信息 车架号(VIN) 是否存在
     * @param carcoreInfo 车辆基本信息
     * @return int
     * @exception
     * @author wuyibo
     * @date 2018-05-09 18:41:36
     */
    public int countVinNumber(CarcoreInfo carcoreInfo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM basic_carcore_info ")
            .append("   WHERE vin_number = :vinNumber AND delete_flag = :deleteFlag");
        if (null != carcoreInfo.getId()) {
            sql.append(" AND id != :id");
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("vinNumber", carcoreInfo.getVinNumber());
        params.put("deleteFlag", carcoreInfo.getDeleteFlag());
        params.put("id", carcoreInfo.getId());
        return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
    }

    /**
     * 车辆基本信息 发动机号 是否存在
     * @param carcoreInfo 车辆基本信息
     * @return int
     * @exception
     * @author wuyibo
     * @date 2018-05-09 18:41:36
     */
    public int countEngineNumber(CarcoreInfo carcoreInfo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM basic_carcore_info ")
            .append("   WHERE engine_number = :engineNumber AND delete_flag = :deleteFlag");
        if (null != carcoreInfo.getId()) {
            sql.append(" AND id != :id");
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("engineNumber", carcoreInfo.getEngineNumber());
        params.put("deleteFlag", carcoreInfo.getDeleteFlag());
        params.put("id", carcoreInfo.getId());
        return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
    }

    /**
     * 车辆基本信息 北斗设备编号 是否存在
     * @param carcoreInfo 车辆基本信息
     * @return int
     * @exception
     * @author wuyibo
     * @date 2018-05-09 18:41:36
     */
    public int countBeidouNumber(CarcoreInfo carcoreInfo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM basic_carcore_info ")
            .append("   WHERE beidou_number = :beidouNumber AND delete_flag = :deleteFlag");
        if (null != carcoreInfo.getId()) {
            sql.append(" AND id != :id");
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("beidouNumber", carcoreInfo.getBeidouNumber());
        params.put("deleteFlag", carcoreInfo.getDeleteFlag());
        params.put("id", carcoreInfo.getId());
        return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, Integer.class);
    }

    /**
     * 查询编号 最大值
     * @param fieldNumber 字段名
     * @param tableName 表名
     * @return
     * @exception
     * @author wuyibo
     * @date 2018-05-14 15:59:41
     */
    public String findNumberMax(String fieldNumber, String tableName) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT MAX(" + fieldNumber + ") FROM " + tableName);
        Map<String, Object> params = Maps.newHashMap();
        params.put("fieldNumber", fieldNumber);
        params.put("tableName", tableName);
        return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, String.class);
    }

    /**
     * 获取详情
     * @param id  id
     * @author weijb
     * @date 2018-07-13 17:29:31
     */
    public CarcoreInfo queryCarDetailByCarId(long id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,car_number,vin_number,engine_number,beidou_number,")
                .append("carbrand_id,carseries_id,carmodel_id,produce_time,remark,car_status, creator,")
                .append("create_time,operator,operate_time,delete_flag FROM basic_carcore_info")
                .append(" WHERE id= :id");
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        return super.findForBean(CarcoreInfo.class, sql.toString(), params);
    }

    /**
     * 根据车辆id删除车辆
     * @param carId 车辆id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @exception
     * @author weijb
     * @date 2018-06-08 13:55:14
     */
    public int deleteCarcoreInfoByCarId(long carId) {
        String sql = "UPDATE basic_carcore_info SET delete_flag = :deleteFlag WHERE id= :carId ";
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("carId", carId);
        map.put("deleteFlag", com.ccbuluo.merchandiseintf.carparts.Constants.Constants.DELETE_FLAG_DELETE);
        return super.updateForMap(sql, map);
    }

    /**
     * 车辆列表分页查询
     * @param carbrandId 品牌id
     * @param carseriesId 车系id
     * @param
     * @param Keyword (车辆编号或是车架号)
     * @param offset 起始数
     * @param pageSize 每页数量
     * @author weijb
     * @date 2018-07-13 19:52:44
     */
    public Page<SearchCarcoreInfoDTO> queryCarcoreInfoList(Long carbrandId, Long carseriesId, Integer carStatus, String Keyword, Integer offset, Integer pageSize){
        Map<String, Object> param = Maps.newHashMap();
        param.put("deleteFlag", Constants.DELETE_FLAG_NORMAL);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT bci.id,bci.car_number,bci.vin_number,bci.car_status,")
                .append("bcm.carbrand_name,bci.carseries_id,bcmmm.carmodel_name")
                .append(" FROM basic_carcore_info bci LEFT JOIN basic_carbrand_manage bcm on bci.carbrand_id=bcm.id ")
                .append(" LEFT JOIN basic_carmodel_manage bcmmm ON bci.carmodel_id=bcmmm.id ")
                .append(" WHERE bci.delete_flag = :deleteFlag ");
        // 品牌
        if (null != carbrandId) {
            param.put("carbrandId", carbrandId);
            sql.append(" AND bci.carbrand_id = :carbrandId ");
        }
        // 车系
        if (null != carseriesId) {
            param.put("carseriesId", carseriesId);
            sql.append(" AND bci.carseries_id = :carseriesId ");
        }
        // 车型
        if (null != carStatus) {
            param.put("carStatus", carStatus);
            sql.append(" AND bci.car_status = :carStatus ");
        }
        // 车架号
        if (StringUtils.isNotBlank(Keyword)) {
            param.put("Keyword", Keyword);
            sql.append(" AND (bci.vin_number LIKE CONCAT('%',:Keyword,'%') OR bci.car_number LIKE CONCAT('%',:Keyword,'%'))");
        }
        sql.append("  ORDER BY bci.operate_time DESC");
        Page<SearchCarcoreInfoDTO> DTOS = super.queryPageForBean(SearchCarcoreInfoDTO.class, sql.toString(), param,offset,pageSize);
        return DTOS;
    }

    //查询未分配的车辆列表
    public List<ListCarcoreInfoDTO> queryundistributedlist(){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT car_number,vin_number ")
                .append(" FROM basic_carcore_info WHERE car_status=0 ");
        Map<String, Object> params = Maps.newHashMap();
        return super.queryListBean(ListCarcoreInfoDTO.class, sql.toString(), params);
    }
    /**
     * 根据车辆code更新车辆状态
     * @param list
     * @return com.ccbuluo.http.StatusDto
     * @exception
     * @author weijb
     * @date 2018-07-31 15:59:51
     */
    public List<Long> updatestatusbycode(List<UpdateCarcoreInfoDTO> list){
        String sql = "update basic_carcore_info set cusmanager_uuid=:cusmanagerUuid, cusmanager_name=:cusmanagerName, car_status=:carStatus  where car_number=:carNumber";
        return batchInsertForListBean(sql, list);
    }

    /**
     * 根据车架号查询车辆信息
     * @param vinNumber 车辆vin
     * @exception
     * @author weijb
     * @date 2018-06-08 13:55:14
     */
    public VinCarcoreInfoDTO getCarInfoByVin(String vinNumber){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT car_number,vin_number,engine_number,beidou_number ")
                .append(" FROM basic_carcore_info WHERE vin_number= :vinNumber");
        Map<String, Object> params = Maps.newHashMap();
        params.put("vinNumber", vinNumber);
        return super.findForBean(VinCarcoreInfoDTO.class, sql.toString(), params);
    }
    /**
     * 根据车辆vin更新车辆的门店信息
     * @param vinNumber 车架号
     * @param storeCode 门店code
     * @param storeName 门店名称
     * @return com.ccbuluo.http.StatusDto
     * @exception
     * @author weijb
     * @date 2018-08-01 15:55:14
     */
    public int updatecarcoreinfobyvin(String vinNumber, Integer storeCode, Integer storeName){
        Map<String, Object> params = Maps.newHashMap();
        params.put("storeCode", storeCode);
        params.put("storeName", storeName);
        params.put("vinNumber", vinNumber);
        String sql = "update basic_carcore_info set store_code=:storeCode, store_name=:storeName, car_status=1  where vin_number=:vinNumber";
        return updateForMap(sql, params);
    }
}
