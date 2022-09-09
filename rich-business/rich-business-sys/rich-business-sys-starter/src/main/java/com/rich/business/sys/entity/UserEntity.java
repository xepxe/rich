package com.rich.business.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rich.common.db.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author xepxe
 * @date 2022/9/9 15:18
 * @desc
 */
@Data
@ToString
@TableName("sys_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity<UserEntity> {
    private static final long serialVersionUID = 2121949774219565061L;

    @ApiModelProperty("用户名")
    String username;
    @ApiModelProperty("昵称")
    String nickname;
    @ApiModelProperty("密码")
    String password;
    @ApiModelProperty("姓名 0女 1男 2位置")
    Integer sex;
    @ApiModelProperty("手机号")
    String phone;
    @ApiModelProperty("邮箱")
    String email;
    @ApiModelProperty("头像")
    String avatar;
    @ApiModelProperty("状态 0停用 1启用")
    Integer status;

}
