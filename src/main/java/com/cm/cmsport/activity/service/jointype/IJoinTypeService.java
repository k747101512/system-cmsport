package com.cm.cmsport.activity.service.jointype;

import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.cmsport.activity.pojo.dtos.jointype.JoinTypeDTO;
import com.cm.cmsport.activity.pojo.vos.jointype.JoinTypeVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IJoinTypeService
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
public interface IJoinTypeService {

    /**
     * 新增活动参加方式
     *
     * @param joinTypeVO
     * @return
     * @throws Exception
     */
    SuccessResult saveJoinType(JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 新增活动参加方式(APP)
     *
     * @param token
     * @param joinTypeVO
     * @return
     * @throws Exception
     */
    SuccessResult saveJoinTypeByToken(String token, JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 新增活动参加方式
     *
     * @param joinTypeVO
     * @return joinTypeId
     * @throws Exception
     */
    String saveJoinTypeReturnId(JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 新增活动参加方式(APP)
     *
     * @param token
     * @param joinTypeVO
     * @return joinTypeId
     * @throws Exception
     */
    String saveJoinTypeByTokenReturnId(String token, JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 删除活动参加方式
     *
     * @param ids
     * @return
     * @throws RemoveException
     */
    SuccessResult removeJoinType(String ids) throws RemoveException;

    /**
     * 删除活动参加方式（物理删除）
     *
     * @param ids
     * @throws RemoveException
     */
    void deleteJoinType(String ids) throws RemoveException;

    /**
     * 删除活动参加方式(APP)
     *
     * @param token
     * @param ids
     * @return
     * @throws RemoveException
     */
    SuccessResult removeJoinTypeByToken(String token, String ids) throws RemoveException;

    /**
     * 修改活动参加方式
     *
     * @param joinTypeId
     * @param joinTypeVO
     * @return
     * @throws Exception
     */
    SuccessResult updateJoinType(String joinTypeId, JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 修改活动参加方式(APP)
     *
     * @param token
     * @param joinTypeId
     * @param joinTypeVO
     * @return
     * @throws Exception
     */
    SuccessResult updateJoinTypeByToken(String token, String joinTypeId, JoinTypeVO joinTypeVO) throws Exception;

    /**
     * 活动参加方式详情(通过ID)
     *
     * @param joinTypeId
     * @return
     * @throws SearchException
     */
    JoinTypeDTO getJoinTypeById(String joinTypeId) throws SearchException;

    /**
     * 活动参加方式列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<JoinTypeDTO> listJoinType(Map<String, Object> params) throws SearchException;

    /**
     * 活动参加方式分页列表
     *
     * @param page
     * @return
     * @throws SearchException
     */
    SuccessResultList<List<JoinTypeDTO>> listPageJoinType(ListPage page) throws SearchException;

    /**
     * 活动参加方式统计
     *
     * @param params
     * @return
     * @throws SearchException
     */
    Integer countNumberJoinType(Map<String, Object> params) throws SearchException;

    /**
     * 活动参加方式统计
     *
     * @param params
     * @return
     * @throws SearchException
     */
    SuccessResultData<Integer> countJoinType(Map<String, Object> params) throws SearchException;

}