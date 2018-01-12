package com.hyc.jms.base;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 简单的消息发送端
 * 
 * @author huayingcao
 *
 */
public class QueueProducer {
	private static final String QUEUE_NAME = "test";

	public static void main(String[] args) throws IOException {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		// 创建连接
		Connection connection = factory.newConnection();
		// 创建频道
		Channel channel = connection.createChannel();
		// 声明一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// 发送十条消息，在每个消息的后面加上.
		for (int i = 0; i < 10; i++) {
			String point = "";
			for (int j = 0; j < i; j++) {
				point += ".";
			}
			String message = "hello world" + point + point.length();
			// 给指定的队列发送消息
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("[X] send'" + message + "'");
		}

	}
}
