package com.defender.common.vo;

import com.defender.common.enums.CommonResponseResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果对象(Result)
 * @author guanlibin
 * @version 1.0
 * @create 2020/9/30 1:16
 */
@Data
@NoArgsConstructor
@ApiModel(value = "结果对象")
public class R {

    @ApiModelProperty(value = "是否成功", example = "success")
    private boolean success;

    @ApiModelProperty(value = "状态码", example = "200")
    private int code;

    @ApiModelProperty(value = "返回信息", example = "成功")
    private String message;


    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    public R(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 响应成功。不携带额外数据。
     * @return
     */
    public static R ok() {
        CommonResponseResultEnum rce = CommonResponseResultEnum.SUCCESS;
        return new R(rce.getSuccess(), rce.getCode(), rce.getMessage());
    }

    /**
     * 响应失败。不携带额外数据。
     * @return
     */
    public static R error() {
        CommonResponseResultEnum rce = CommonResponseResultEnum.UNKNOWN_REASON;
        return new R(rce.getSuccess(), rce.getCode(), rce.getMessage());
    }

    /**
     * 不携带额外数据。使用结果枚举对象来构建R对象
     * @param rce
     * @return
     */
    public static R setResult(CommonResponseResultEnum rce) {
        return new R(rce.getSuccess(), rce.getCode(), rce.getMessage());
    }

    /**
     * 自定义success
     * @param success 是否成功
     * @return
     */
    public R success(boolean success) {
        this.success = success;
        return this;
    }

    /**
     * 自定义code
     * @param code 状态码
     * @return
     */
    public R code(int code) {
        this.code = code;
        return this;
    }

    /**
     * 自定义message
     * @param message
     * @return
     */
    public R message(String message) {
        this.message = message;
        return this;
    }

    /**
     * k-v形式添加数据
     * @param key
     * @param value
     * @return
     */
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * map形式添加数据
     * @param key
     * @param value
     * @return
     */
    public R data(Map<String, Object> map) {
        this.data = map;
        return this;
    }
}
