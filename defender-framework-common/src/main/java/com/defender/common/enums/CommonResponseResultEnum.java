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
	SUCCESS(true, 20000,"成功"),
	/**
	 * 未知错误
	 */
	UNKNOWN_REASON(false, 20001, "未知错误"),
	/**
	 * sql语法错误
	 */
	BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
	/**
	 * json解析异常
	 */
	JSON_PARSE_ERROR(false, 21002, "json解析异常"),
	/**
	 * 参数不正确
	 */
	PARAM_ERROR(false, 21003, "参数不正确");

	private final Boolean success;

	private final Integer code;

	private final String message;

}