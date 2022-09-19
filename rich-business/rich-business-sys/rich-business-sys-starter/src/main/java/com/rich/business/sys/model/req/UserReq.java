package com.rich.business.sys.model.req;

import com.rich.common.db.model.PageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xepxe
 * @date 2022/9/9 16:07
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserReq extends PageReq {
    private static final long serialVersionUID = 3562536498101821889L;
    String username;
    String nickname;
    String email;
    String phone;
    Integer sex;

}
