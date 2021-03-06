package com.ccbuluo.business.platform.custmanager.service;

import com.ccbuluo.business.custmanager.allocateapply.dto.QueryPendingMaterialsDTO;
import com.ccbuluo.business.platform.allocateapply.dto.QueryCustManagerListDTO;
import com.ccbuluo.business.platform.custmanager.dto.CustManagerDetailDTO;
import com.ccbuluo.business.platform.custmanager.dto.QueryUserListDTO;
import com.ccbuluo.business.platform.custmanager.entity.BizServiceCustmanager;
import com.ccbuluo.db.Page;
import com.ccbuluo.http.StatusDto;
import com.ccbuluo.http.StatusDtoThriftList;
import com.ccbuluo.usercoreintf.dto.UserInfoDTO;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

/**
 * 客户经理
 * @author zhangkangjian
 * @date 2018-07-18 10:24:12
 */
public interface CustmanagerService {
    /**
     * 创建客户经理
     * @param userInfoDTO 用户的基本信息
     * @param bizServiceCustmanager 用户业务数据
     * @return
     * @author zhangkangjian
     * @date 2018-07-18 10:30:22
     */
    StatusDto<String> createCustManager(UserInfoDTO userInfoDTO, BizServiceCustmanager bizServiceCustmanager);
    /**
     * 查询用户列表
     * @param userInfoDTO 查询条件
     * @return StatusDtoThriftList
     * @author zhangkangjian
     * @date 2018-07-18 16:55:03
     */
    StatusDto<Page<QueryUserListDTO>> queryUserList(UserInfoDTO userInfoDTO);
    /**
     * 编辑客户经理
     * @param userInfoDTO 用户的基本信息
     * @param bizServiceCustmanager 用户业务数据
     * @return StatusDto
     * @author zhangkangjian
     * @date 2018-07-18 10:30:22
     */
    StatusDto<String> editUser(UserInfoDTO userInfoDTO, BizServiceCustmanager bizServiceCustmanager);
    /**
     * 查询用户的详情
     * @param useruuid 用户的uuid
     * @return StatusDto
     * @author zhangkangjian
     * @date 2018-07-19 14:47:07
     */
    StatusDto<CustManagerDetailDTO> custManagerDetail(String useruuid) throws IOException;
    /**
     * 更新客户经理信息
     * @param bizServiceCustmanager 客户经理信息
     * @return StatusDto
     * @author zhangkangjian
     * @date 2018-07-25 14:14:11
     */
    StatusDto<String> updateCustManager(BizServiceCustmanager bizServiceCustmanager);
    /**
     * 获取组织架构子节点
     * @param parentId 组织架构父级id
     * @param isSearchClose 是否获取关闭的组织架构
     * @return StatusDto
     * @author zhangkangjian
     * @date 2018-07-31 14:58:20
     */
    StatusDto queryOrgList(int parentId, boolean isSearchClose);
    /**
     * 查询客户经理列表(创建申请)
     * @param queryCustManagerListDTO 查询条件
     * @exception 
     * @return 
     * @author zhangkangjian
     * @date 2018-08-09 19:03:17
     */
    Page<QueryCustManagerListDTO> queryCustManagerList(QueryCustManagerListDTO queryCustManagerListDTO);

    /**
     * 根据机构编号查询客户经理
     * @param orgCodes 机构编号
     * @return 客户经理
     * @author liuduo
     * @date 2018-09-05 15:54:48
     */
    List<BizServiceCustmanager> queryCustManagerListByOrgCode(List<String> orgCodes);
    /**
     *  查询客户经理物料的信息
     * @param useruuid 客户经理uuid
     * @return List<QueryUserListDTO> 物料列表
     * @author zhangkangjian
     * @date 2018-09-17 13:58:30
     */
    List<QueryPendingMaterialsDTO> queryCustMaterials(String useruuid);
}
