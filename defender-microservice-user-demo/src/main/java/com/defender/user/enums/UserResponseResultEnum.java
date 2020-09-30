package com.defender.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author guanlibin
 * @version 1.0
 * @since 2020/9/30 13:10
 */
@Getter
@AllArgsConstructor
public enum UserResponseResultEnum {

    /**
     * 用户id格式错误
     */
    USER_ID_ILLEGAL(false, 400, "用户id不合法");


    private final boolean success;
    private final int code;
    private final String message;
}
