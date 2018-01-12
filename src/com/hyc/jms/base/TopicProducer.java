package com.hyc.jms.base;

import java.io.IOException;
import java.util.Date;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicProducer {

	private static final String EXCHANGE_NAME = "my-exchange";

	public static void main(String[] args) {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			// 创建连接
			Connection connection = factory.newConnection();
			// 创建频道
			Channel channel = connection.createChannel();
			// 声明交换机以及类型
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			// 向交换机发送消息
			String message = new Date().toLocaleString() + ":log somthing";
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			System.out.println("[X] send message" + message);
			channel.close();
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
