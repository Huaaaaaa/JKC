package com.hyc.jms.consumer;
/**
 * 消费者接口
 * @author huayingcao
 *
 */
public abstract class BasicConsumer extends Thread {

	/*
	 * 创建连接
	 */
	public abstract void initConnection();

	/*
	 * 关闭连接
	 */
	public abstract void closeConnection();

	/*
	 * 经过retryTime时间后重新连接
	 */
	public abstract void reConnection(Long retryTime);
}
