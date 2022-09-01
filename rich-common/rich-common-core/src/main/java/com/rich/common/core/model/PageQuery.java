package com.rich.common.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xepxe
 * @date 2022/9/1 16:02
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode
public class PageQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
