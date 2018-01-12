package com.hyc.jms.base;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 基础的点对点消费者端
 * 
 * @author huayingcao
 *
 */
public class QueueConsumer {

	private static final String QUEUE_NAME = "test";

	public static void main(String[] args) throws IOException,
			ShutdownSignalException, ConsumerCancelledException,
			InterruptedException {
		// 创建不同的工作进程用以区分
		int hashCode = QueueingConsumer.class.hashCode();
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		// 创建连接
		Connection connection = factory.newConnection();
		// 创建频道
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(hashCode
				+ "[*] waiting for message,to exist press CTRL +C ");
		// 指定该队列的消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(hashCode + "[X] received the message" + message);
			doWork(message);
			System.out.println(hashCode + "[X] done");
		}
	}

	private static void doWork(String task) throws InterruptedException {
		for (char c : task.toCharArray()) {
			if (c == '.') {
				Thread.sleep(3000);
			}
		}
	}
}
