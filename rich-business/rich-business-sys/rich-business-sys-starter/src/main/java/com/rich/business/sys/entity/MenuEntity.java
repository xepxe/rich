package com.rich.business.sys.entity;

import com.rich.common.db.model.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author xepxe
 * @date 2022/9/9 15:49
 * @desc
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class MenuEntity extends BaseEntity {
    Long pid;
    @ApiModelProperty("菜单名称")
    String name;
    @ApiModelProperty("菜单类型 0菜单 1按钮")
    Integer type;
    @ApiModelProperty("前端路径")
    String path;
    @ApiModelProperty("权限标志")
    String permission;
    @ApiModelProperty("菜单图标")
    String icon;
    @ApiModelProperty("状态 0停用 1启用")
    Integer status;
    @ApiModelProperty("顺序")
    Integer order;

}
