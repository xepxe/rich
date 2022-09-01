package com.rich.common.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author xepxe
 * @date 2022/9/1 16:05
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class PageResult<T> extends PageQuery {
    private Long total;
    private List<T> records;
}
