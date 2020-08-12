package com.cm.cmsport.activity.service.jointype.impl;

import com.cm.common.base.AbstractService;
import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.cmsport.activity.dao.jointype.IJoinTypeDao;
import com.cm.cmsport.activity.pojo.dtos.jointype.JoinTypeDTO;
import com.cm.cmsport.activity.pojo.vos.jointype.JoinTypeVO;
import com.cm.cmsport.activity.service.jointype.IJoinTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: JoinTypeServiceImpl
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
@Service
public class JoinTypeServiceImpl extends AbstractService implements IJoinTypeService {

    @Autowired
    private IJoinTypeDao joinTypeDao;

    @Override
    public SuccessResult saveJoinType(JoinTypeVO joinTypeVO) throws Exception {
        saveJoinTypeInfo(null, joinTypeVO);
        return new SuccessResult();
    }

    @Override
    public SuccessResult saveJoinTypeByToken(String token, JoinTypeVO joinTypeVO) throws Exception {
        saveJoinTypeInfo(token, joinTypeVO);
        return new SuccessResult();
    }

    @Override
    public String saveJoinTypeReturnId(JoinTypeVO joinTypeVO) throws Exception {
        return saveJoinTypeInfoReturnId(null, joinTypeVO);
    }

    @Override
    public String saveJoinTypeByTokenReturnId(String token, JoinTypeVO joinTypeVO) throws Exception {
        return saveJoinTypeInfoReturnId(token, joinTypeVO);
    }

    /**
     * 新增活动参加方式
     *
     * @param token
     * @param joinTypeVO
     * @throws Exception
     */
    private void saveJoinTypeInfo(String token, JoinTypeVO joinTypeVO) throws Exception {
        saveJoinTypeInfoReturnId(token, joinTypeVO);
    }

    /**
     * 新增活动参加方式
     *
     * @param token
     * @param joinTypeVO
     * @return joinTypeId
     * @throws Exception
     */
    private String saveJoinTypeInfoReturnId(String token, JoinTypeVO joinTypeVO) throws Exception {
        String joinTypeId = UUIDUtil.getUUID();
        Map<String, Object> params = HashMapUtil.beanToMap(joinTypeVO);
        params.put("joinTypeId", joinTypeId);
        if (token != null) {
            setSaveInfo(token, params);
        } else {
            setSaveInfo(params);
        }
        joinTypeDao.saveJoinType(params);
        return joinTypeId;
    }

    @Override
    public SuccessResult removeJoinType(String ids) throws RemoveException {
        removeJoinTypeInfo(null, ids);
        return new SuccessResult();
    }

    @Override
    public SuccessResult removeJoinTypeByToken(String token, String ids) throws RemoveException {
        removeJoinTypeInfo(token, ids);
        return new SuccessResult();
    }

    /**
     * 删除活动参加方式
     *
     * @param token
     * @param ids
     */
    private void removeJoinTypeInfo(String token, String ids) {
        Map<String, Object> params = getHashMap(3);
        params.put("joinTypeIds", Arrays.asList(ids.split("_")));
        if (token != null) {
            setUpdateInfo(token, params);
        } else {
            setUpdateInfo(params);
        }
        joinTypeDao.removeJoinType(params);
    }

    @Override
    public void deleteJoinType(String ids) throws RemoveException {
        Map<String, Object> params = getHashMap(3);
        params.put("joinTypeIds", Arrays.asList(ids.split("_")));
        joinTypeDao.deleteJoinType(params);
    }

    @Override
    public SuccessResult updateJoinType(String joinTypeId, JoinTypeVO joinTypeVO) throws Exception {
        updateJoinTypeInfo(null, joinTypeId, joinTypeVO);
        return new SuccessResult();
    }

    @Override
    public SuccessResult updateJoinTypeByToken(String token, String joinTypeId, JoinTypeVO joinTypeVO) throws Exception {
        updateJoinTypeInfo(token, joinTypeId, joinTypeVO);
        return new SuccessResult();
    }

    /**
     * 修改活动参加方式
     *
     * @param token
     * @param joinTypeId
     * @param joinTypeVO
     */
    private void updateJoinTypeInfo(String token, String joinTypeId, JoinTypeVO joinTypeVO) throws Exception {
        Map<String, Object> params = HashMapUtil.beanToMap(joinTypeVO);
        params.put("joinTypeId", joinTypeId);
        if (token != null) {
            setUpdateInfo(token, params);
        } else {
            setUpdateInfo(params);
        }
        joinTypeDao.updateJoinType(params);
    }

    @Override
    public JoinTypeDTO getJoinTypeById(String joinTypeId) throws SearchException {
        Map<String, Object> params = super.getHashMap(1);
        params.put("joinTypeId", joinTypeId);
        return joinTypeDao.getJoinType(params);
    }

    @Override
    public List<JoinTypeDTO> listJoinType(Map<String, Object> params) throws SearchException {
        return joinTypeDao.listJoinType(params);
    }

    @Override
    public SuccessResultList<List<JoinTypeDTO>> listPageJoinType(ListPage page) throws SearchException {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<JoinTypeDTO> joinTypeDTOs = joinTypeDao.listJoinType(page.getParams());
        PageInfo<JoinTypeDTO> pageInfo = new PageInfo<>(joinTypeDTOs);
        return new SuccessResultList<>(joinTypeDTOs, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public Integer countNumberJoinType(Map<String, Object> params) throws SearchException {
        Integer count = joinTypeDao.countJoinType(params);
        return count == null ? 0 : count;
    }

    @Override
    public SuccessResultData<Integer> countJoinType(Map<String, Object> params) throws SearchException {
        return new SuccessResultData<>(countNumberJoinType(params));
    }

}