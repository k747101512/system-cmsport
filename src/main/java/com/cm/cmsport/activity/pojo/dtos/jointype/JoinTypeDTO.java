package com.cm.cmsport.activity.pojo.dtos.jointype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: JoinTypeDTO
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
@ApiModel
public class JoinTypeDTO {

    @ApiModelProperty(name = "joinTypeId", value = "主键")
    private String joinTypeId;
    @ApiModelProperty(name = "typeName", value = "类型名称")
    private String typeName;
    @ApiModelProperty(name = "needColumn", value = "所需信息")
    private String needColumn;

    public String getJoinTypeId() {
        return joinTypeId == null ? "" : joinTypeId.trim();
    }

    public void setJoinTypeId(String joinTypeId) {
        this.joinTypeId = joinTypeId;
    }

    public String getTypeName() {
        return typeName == null ? "" : typeName.trim();
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNeedColumn() {
        return needColumn == null ? "" : needColumn.trim();
    }

    public void setNeedColumn(String needColumn) {
        this.needColumn = needColumn;
    }


}
