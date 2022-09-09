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
public class DeptEntity extends BaseEntity<DeptEntity> {
    private static final long serialVersionUID = 2121949774219565061L;
    Long pid;
    String ancestors;
    String name;
    Long leaderId;
    Integer sort;
    Integer status;
}
