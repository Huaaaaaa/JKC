package com.hyc.jms.consumer;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hyc.jms.JmsConfig;
import com.hyc.jms.JmsConnection;
import com.hyc.jms.core.ExchangeType;
import com.hyc.jms.core.MessagerHandler;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 订阅者模型消费者实现类
 * 声明一个转发器---为转发器绑定一个队列---为该队列绑定一个消费者
 * 
 * @author huayingcao
 *
 */
public class TopicSubscriber extends BasicConsumer {

	Logger log = Logger.getLogger(TopicSubscriber.class);

	private String exchangeName = null;
	private Connection connection = null;
	private Channel channel = null;
	private QueueingConsumer consumer = null;
	private MessagerHandler handler = null;

	public TopicSubscriber(String exchangeName, MessagerHandler handler) {
		this.exchangeName = exchangeName;
		this.handler = handler;
		initConnection();
	}

	@Override
	public void initConnection() {
		log.info("init topic consumer connection,exchangeName:" + exchangeName);
		JmsConnection jc = new JmsConnection();
		try {
			this.connection = jc.getConnection();
			this.channel = connection.createChannel();
			//声明一个转发器及类型
			this.channel.exchangeDeclare(exchangeName,
					ExchangeType.FANOUT.getCode());
			//为该转发器绑定一个队列,获取指定的消息，本例中"",即：exchangeName为routingKey，""为bindingKey，可以获取到指定的消息
			//注意：指定bindingKey的前提是转发器的类型为direct而不是fanout
			String queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, exchangeName, "");
			//为该队列绑定一个消费者
			this.consumer = new QueueingConsumer(channel);
			channel.basicConsume(queueName, true, consumer);
		} catch (IOException e) {
			log.error("init topic consumer connection error:" + e.getMessage());
		}

	}

	@Override
	public void closeConnection() {
		log.info("close topic connection");
		if (channel != null || channel.isOpen()) {
			try {
				channel.close();
			} catch (IOException e) {
				log.error("close topic channel error:" + e.getMessage());
			}
		}
		if (connection != null || connection.isOpen()) {
			try {
				connection.close();
			} catch (IOException e) {
				log.error("close topic connection error:" + e.getMessage());
			}
		}

	}

	@Override
	public void reConnection(Long retryTime) {
		log.info("reConnection topic connection,retryTime:" + retryTime);
		try {
			Thread.sleep(retryTime);
		} catch (InterruptedException e) {
			log.error("reConnection topic connection InterruptedException :"
					+ e);
		}
		if (channel != null || connection != null) {
			closeConnection();
			initConnection(); 
		}
	}

}
