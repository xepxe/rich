package com.rich.business.sys.model.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xepxe
 * @date 2022/9/19 10:08
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserUpdateReq extends UserSaveReq{
    private static final long serialVersionUID = 8681599888609498806L;
    private Integer id;
}
