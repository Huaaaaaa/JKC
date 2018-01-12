package com.hyc.jms.producer;

import java.util.HashMap;
import java.util.Map;

/**
 * jms发送者
 * 
 * @author huayingcao
 *
 */
public class JmsSender {
	private Map<String, QueueProducer> queueProducer = new HashMap<String, QueueProducer>();
	private Map<String, TopicPublisher> topicPublisher = new HashMap<String, TopicPublisher>();

	/*
	 * 使用点对点模式发送消息
	 */
	public boolean queueSend(String taskQueueName, byte[] messager,
			int retryTime) {
		QueueProducer producer = queueProducer.get(taskQueueName);
		if (producer == null) {
			producer = new QueueProducer(taskQueueName);
			queueProducer.put(taskQueueName, producer);
		}
		return producer.sendMessager(messager, retryTime);
	}

	/*
	 * 使用订阅者-发布者模式发送消息
	 */
	public boolean topicSend(String exchangeName, byte[] messager, int retryTime) {
		TopicPublisher publisher = topicPublisher.get(exchangeName);
		if (publisher == null) {
			publisher = new TopicPublisher(exchangeName);
			topicPublisher.put(exchangeName, publisher);
		}
		return publisher.sendMessager(messager, retryTime);
	}

	/*
	 * 关闭所有的连接
	 */
	public void closeConn() {
		for (QueueProducer qp : queueProducer.values()) {
			qp.closeConnection();
		}

		for (TopicPublisher tp : topicPublisher.values()) {
			tp.closeConnection();
		}
	}

}
