package com.defender.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 定义了一些常见的响应结果
 */
@Getter
@AllArgsConstructor
public enum CommonResponseResultEnum {

	/**
	 * 成功
	 */
	SUCCESS(true, 200,"成功"),
	/**
	 * 未知错误
	 */
	UNKNOWN_REASON(false, 500, "未知错误"),
	/**
	 * sql语法错误
	 */
	BAD_SQL_GRAMMAR(false, 500, "sql语法错误"),
	/**
	 * json解析异常
	 */
	JSON_PARSE_ERROR(false, 400, "json解析异常"),
	/**
	 * 参数不正确
	 */
	PARAM_ERROR(false, 400, "参数不正确");

	private final Boolean success;

	private final Integer code;

	private final String message;

}