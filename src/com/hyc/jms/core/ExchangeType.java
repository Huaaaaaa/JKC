package com.hyc.jms.core;

/**
 * exchangeName定义
 * 
 * @author huayingcao
 *
 */
public enum ExchangeType {

	/**
	 * 处理路由键
	 */
	DIRECT("direct"),

	/**
	 * 不处理路由键
	 */
	FANOUT("fanout"),

	/**
	 * 将路由键和某模式进行匹配
	 */
	TOPIC("topic");
	public String code;

	ExchangeType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
