package com.hyc.jms.consumer;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hyc.jms.JmsConfig;
import com.hyc.jms.JmsConnection;
import com.hyc.jms.core.MessagerHandler;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 点对点模式的消费者
 * 
 * @author huayingcao
 *
 */
public class QueueConsumer extends BasicConsumer {
	private static final Logger log = Logger.getLogger(QueueConsumer.class);
	private String taskQueueName = null;
	private Connection connection = null;
	private Channel channel = null;
	private QueueingConsumer queueConsumer = null;
	private MessagerHandler handler = null;

	public QueueConsumer(String taskQueueName, MessagerHandler handler) {
		this.taskQueueName = taskQueueName;
		this.handler = handler;
		initConnection();
	}

	@Override
	public void initConnection() {
		log.info("init queue consumer connection,taskQueueName:"
				+ taskQueueName);
		JmsConnection jc = new JmsConnection();
		try {
			this.connection = jc.getConnection();
			this.channel = connection.createChannel();
			//声明一个队列
			this.channel.queueDeclare(taskQueueName, JmsConfig.getDurable(),
					false, JmsConfig.getAutoDelete(), null);
			//声明不要在同一时间给同一消费者超过一条消息，即每个消费者每次只接受一条消息进行处理，传入的参数是prefetchCount
			this.channel.basicQos(1);
			this.queueConsumer = new QueueingConsumer(channel);
			//为该队列指定一个消费者
			channel.basicConsume(taskQueueName, false, queueConsumer);
		} catch (IOException e) {
			log.error("init queue consumer connection eror,taskQueueName"
					+ taskQueueName);
		}

	}

	@Override
	public void closeConnection() {
		log.info("close queue consumer connection,taskQueueName"
				+ taskQueueName);
		if (channel != null || channel.isOpen()) {
			try {
				channel.close();
			} catch (IOException e) {
				log.error("close queue consumer channle error:"
						+ e.getMessage());
			}
		}

		if (connection != null || connection.isOpen()) {
			try {
				connection.close();
			} catch (IOException e) {
				log.error("close queue consumer connection error:"
						+ e.getMessage());
			}
		}
	}

	@Override
	public void reConnection(Long delay) {
		log.info("reConnnection queue consumer,retryTime:" + delay);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		}
		if (connection != null || channel != null) {
			closeConnection();
			initConnection();
		}

	}

}
