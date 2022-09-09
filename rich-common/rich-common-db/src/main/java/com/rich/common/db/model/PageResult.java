package com.rich.common.db.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    private static final long serialVersionUID = -6085846093637078044L;
    private Long total;
    private List<T> records;

    public static <T> PageResult<T> to(Page<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(page.getRecords());
        return pageResult;
    }
}
