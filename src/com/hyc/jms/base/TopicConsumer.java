package com.hyc.jms.base;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class TopicConsumer {
	private static final String EXCHANGE_NAME = "my-exchange";

	public static void main(String[] args) throws ShutdownSignalException,
			ConsumerCancelledException, InterruptedException {
		// 生成哈希码，用来标示进程
		int hashCode = QueueingConsumer.class.hashCode();
		try {
			// 创建连接工厂
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			// 创建连接
			Connection connection = factory.newConnection();
			// 创建频道
			Channel channel = connection.createChannel();
			// 声明交换机以及类型
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			// 为交换机指定队列名
			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, EXCHANGE_NAME, "");
			System.out.println("[*] waiting for message");
			// 指定处理消息的消费者
			QueueingConsumer consumer = new QueueingConsumer(channel);
			// 为转发器绑定消费者,第二个参数为自动应答，无需设置手动
			channel.basicConsume(queueName, true, consumer);

			while (true) {
				QueueingConsumer.Delivery delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println(hashCode + "[x] received the message"
						+ message);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
