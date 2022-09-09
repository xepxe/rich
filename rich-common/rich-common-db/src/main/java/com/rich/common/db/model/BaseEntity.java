package com.rich.common.db.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xepxe
 * @date 2022/9/1 15:50
 * @desc
 */
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<B extends Model<B>> extends Model<B> implements Serializable {
    private static final long serialVersionUID = 9050642043692021774L;
    @TableId(type = IdType.ASSIGN_ID)
    Long id;
    String createBy;
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
    String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;
}
