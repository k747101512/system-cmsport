package com.cm.cmsport.activity.controller.apis.jointype;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.base.AbstractController;
import com.cm.common.component.SecurityComponent;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.pojo.dtos.CurrentUserIdInfoDTO;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.cmsport.activity.pojo.dtos.jointype.JoinTypeDTO;
import com.cm.cmsport.activity.pojo.vos.jointype.JoinTypeVO;
import com.cm.cmsport.activity.service.jointype.IJoinTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JoinTypeController
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "活动参加方式接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/jointype")
public class JoinTypeController extends AbstractController {

    @Autowired
    private IJoinTypeService joinTypeService;
    @Autowired
    private SecurityComponent securityComponent;

    @ApiOperation(value = "新增活动参加方式", notes = "新增活动参加方式接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("savejointype")
    @CheckRequestBodyAnnotation
    public SuccessResult saveJoinType(@RequestBody JoinTypeVO joinTypeVO) throws Exception {
        return joinTypeService.saveJoinType(joinTypeVO);
    }

    @ApiOperation(value = "删除活动参加方式(id列表)", notes = "删除活动参加方式(id列表)接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ID列表，用下划线分隔", paramType = "path", example = "1_2_3")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("removejointype/{ids}")
    public SuccessResult removeJoinType(@PathVariable("ids") String ids) throws RemoveException {
        return joinTypeService.removeJoinType(ids);
    }

    @ApiOperation(value = "修改活动参加方式", notes = "修改活动参加方式接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "joinTypeId", value = "活动参加方式ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("updatejointype/{joinTypeId}")
    @CheckRequestBodyAnnotation
    public SuccessResult updateJoinType(@PathVariable("joinTypeId") String joinTypeId, @RequestBody JoinTypeVO joinTypeVO) throws Exception {
        return joinTypeService.updateJoinType(joinTypeId, joinTypeVO);
    }

    @ApiOperation(value = "活动参加方式详情(通过ID)", notes = "活动参加方式详情(通过ID)接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "joinTypeId", value = "活动参加方式ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getjointypebyid/{joinTypeId}")
    public JoinTypeDTO getJoinTypeById(@PathVariable("joinTypeId") String joinTypeId) throws SearchException {
        return joinTypeService.getJoinTypeById(joinTypeId);
    }

    @ApiOperation(value = "活动参加方式列表", notes = "活动参加方式列表接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listjointype")
    public List<JoinTypeDTO> listJoinType() throws SearchException {
        Map<String, Object> params = requestParams();
        return joinTypeService.listJoinType(params);
    }

    @ApiOperation(value = "活动参加方式分页列表", notes = "活动参加方式分页列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "query", dataType = "int", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagejointype")
    public SuccessResultList<List<JoinTypeDTO>> listPageJoinType(ListPage page) throws SearchException {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return joinTypeService.listPageJoinType(page);
    }

    @ApiOperation(value = "活动参加方式统计", notes = "活动参加方式统计接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("countjointype")
    SuccessResultData<Integer> countJoinType() throws SearchException {
        Map<String, Object> params = requestParams();
        return joinTypeService.countJoinType(params);
    }

    @ApiOperation(value = "当前用户id信息", notes = "当前用户id信息接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getcurrentuseridinfo")
    public CurrentUserIdInfoDTO getCurrentUserIdInfo() {
        return securityComponent.getCurrentUserIdInfo();
    }

}