package com.rich.common.db.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xepxe
 * @date 2022/9/1 16:02
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode
public class PageQuery implements Serializable {
    private static final long serialVersionUID = 6432917736302096688L;
    private Long pageNum = 1L;
    private Long pageSize = 10L;
}
