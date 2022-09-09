package com.rich.business.sys.entity;

import com.rich.common.db.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author xepxe
 * @date 2022/9/9 15:18
 * @desc
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity<RoleEntity> {
    private static final long serialVersionUID = 2121949774219565061L;
    @ApiModelProperty("角色编码")
    String code;
    @ApiModelProperty("角色名")
    String name;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("排序")
    Integer sort;
    @ApiModelProperty("状态 0停用 1启用")
    Integer status;

}
