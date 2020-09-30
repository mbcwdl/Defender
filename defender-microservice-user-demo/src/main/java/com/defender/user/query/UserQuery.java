package com.defender.user.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author guanlibin
 * @version 1.0
 * @since 2020/9/30 13:47
 */
@ApiModel(value = "User查询对象", description = "对查询用户所需参数进行封装")
@Data
public class UserQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名 模糊查询")
    private String username;

    @ApiModelProperty(value = "手机号 完全匹配查询")
    private String phone;
}
