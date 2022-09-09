package com.rich.business.sys.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author xepxe
 * @date 2022/9/9 15:18
 * @desc
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleEntity implements Serializable {
    private static final long serialVersionUID = 2121949774219565061L;
    Long userId;
    Long roleId;
}
