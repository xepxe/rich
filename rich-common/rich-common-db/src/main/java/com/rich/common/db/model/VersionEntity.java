package com.rich.common.db.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xepxe
 * @date 2022/9/1 16:07
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class VersionEntity<V extends Model<V>> extends BaseEntity<V> implements Serializable {
    private static final long serialVersionUID = 7761410192609434382L;
    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version;
}
