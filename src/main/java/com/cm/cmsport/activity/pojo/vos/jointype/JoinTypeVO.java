package com.cm.cmsport.activity.pojo.vos.jointype;

import com.cm.common.annotation.CheckEmptyAnnotation;
import com.cm.common.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: JoinTypeVO
 * @Description: 活动参加方式
 * @Author: WenG
 * @Date: 2020-08-12 15:10
 * @Version: 1.0
 **/
@ApiModel
public class JoinTypeVO {

    @ApiModelProperty(name = "typeName", value = "类型名称")
    @CheckEmptyAnnotation(name = "类型名称")
    private String typeName;
    @ApiModelProperty(name = "needColumn", value = "所需信息")
    private String needColumn;

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
