package com.rich.business.sys.model.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author xepxe
 * @date 2022/9/14 9:47
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode
public class UserSaveReq implements Serializable {
    private static final long serialVersionUID = 1613535991048495539L;
    @NotBlank(message = "密码不可为空")
    private String username;
    @NotBlank(message = "昵称不可为空")
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    @NotBlank(message = "密码不可为空")
    private String password;
    private String avatar;
}
