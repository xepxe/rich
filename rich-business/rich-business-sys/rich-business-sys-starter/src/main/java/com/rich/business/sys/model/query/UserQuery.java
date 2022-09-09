package com.rich.business.sys.model.query;

import com.rich.common.db.model.PageQuery;
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
public class UserQuery extends PageQuery {
    String username;
    String nickname;
}
