package com.hyc.jms.core;

import com.hyc.jms.core.ConsumerDefine;
/**
 * 处理消息的接口，使用ConsumerDefine定义队列名称，消息的类型和消费者数量
 * messager为消息主体
 * @author huayingcao
 *
 */
public interface MessagerHandler {
	@ConsumerDefine
	public void handleMessager(byte[] messager);
}
