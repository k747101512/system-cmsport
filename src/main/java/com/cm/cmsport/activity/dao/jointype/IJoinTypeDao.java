package com.cm.cmsport.activity.dao.jointype;

import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.exception.UpdateException;
import com.cm.common.result.SuccessResultList;
import com.cm.cmsport.activity.pojo.dtos.jointype.JoinTypeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IJoinTypeDao
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
@Repository
public interface IJoinTypeDao {

    /**
     * 新增活动参加方式
     *
     * @param params
     * @throws SaveException
     */
    void saveJoinType(Map<String, Object> params) throws SaveException;

    /**
     * 删除活动参加方式
     *
     * @param params
     * @throws RemoveException
     */
    void removeJoinType(Map<String, Object> params) throws RemoveException;

    /**
    * 删除活动参加方式（物理）
    *
    * @param params
    * @throws RemoveException
    */
    void deleteJoinType(Map<String, Object> params) throws RemoveException;

    /**
     * 修改活动参加方式
     *
     * @param params
     * @throws UpdateException
     */
    void updateJoinType(Map<String, Object> params) throws UpdateException;

    /**
     * 活动参加方式详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    JoinTypeDTO getJoinType(Map<String, Object> params) throws SearchException;

    /**
     * 活动参加方式列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<JoinTypeDTO> listJoinType(Map<String, Object> params) throws SearchException;

    /**
    * 活动参加方式统计
    *
    * @param params
    * @return
    * @throws SearchException
    */
    Integer countJoinType(Map<String, Object> params) throws SearchException;

}