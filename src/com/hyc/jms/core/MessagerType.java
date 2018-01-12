package com.hyc.jms.core;

/**
 * 定义消息类型
 * 
 * @author huayingcao
 *
 */
public enum MessagerType {

	/*
	 * 队列消息：点对点类型，一对一
	 */
	QUEUE,

	/*
	 * 订阅消息：发布者/订阅者模型，一对多
	 */
	TOPIC;

	/*
	 * 默认类型为点对点
	 */
	public static final MessagerType DEFAULT = QUEUE;
}
