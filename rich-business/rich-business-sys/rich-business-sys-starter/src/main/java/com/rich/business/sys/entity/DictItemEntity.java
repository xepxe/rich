package com.rich.business.sys.entity;

import com.rich.common.db.model.BaseEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author xepxe
 * @date 2022/9/9 15:35
 * @desc
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class DictItemEntity extends BaseEntity<DictItemEntity> {
    private static final long serialVersionUID = -5402472432078738529L;
    Long dictId;
    String value;
    String label;
    String description;
    Integer sort;

}
