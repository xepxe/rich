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
public class PageVO<T> extends PageReq {
    private static final long serialVersionUID = -6085846093637078044L;
    private Long total;
    private List<T> records;

    public static <T> PageVO<T> to(Page<T> page) {
        PageVO<T> pageResult = new PageVO<>();
        pageResult.setPageNum(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(page.getRecords());
        return pageResult;
    }
}
