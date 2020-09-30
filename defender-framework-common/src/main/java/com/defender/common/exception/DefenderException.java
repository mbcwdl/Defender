package com.defender.common.exception;

import com.defender.common.enums.CommonResponseResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author guanlibin
 * @version 1.0
 * @since 2020/9/30 12:46
 */
@Data
@ApiModel(value = "自定义异常")
public class DefenderException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;


    public DefenderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DefenderException(CommonResponseResultEnum commonResponseResultEnum) {
        super(commonResponseResultEnum.getMessage());
        this.code = commonResponseResultEnum.getCode();
    }

    @Override
    public String toString() {
        return "DefenderException{" +
                "code=" + code +
                ",message=" + this.getMessage() +
                '}';
    }
}
