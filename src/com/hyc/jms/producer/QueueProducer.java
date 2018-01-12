package com.hyc.jms.producer;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hyc.jms.JmsConfig;
import com.hyc.jms.JmsConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 点对点模式的生产者
 * 
 * @author huayingcao
 *
 */
public class QueueProducer {

	static final Logger log = Logger.getLogger(QueueProducer.class);
	private String taskQueueName = null;
	private Connection connection = null;
	private Channel channel = null;

	public QueueProducer(String taskQueueName) {
		this.taskQueueName = taskQueueName;
		initConnection();
	}

	/*
	 * 初始化连接---一个队列创建一个连接
	 */
	public void initConnection() {
		log.info("init queue producer connection, taskQueueName:"
				+ taskQueueName);
		JmsConnection jc = new JmsConnection();
		try {
			this.connection = jc.getConnection();
			this.channel = connection.createChannel();
			/**
			 * 声明一个队列，参数的意义依次为：
			 * 队列名称，rabbitMQ是否持久化，发送的消息是否持久化，是否自动删除，发送的消息体
			 */
			this.channel.queueDeclare(taskQueueName, JmsConfig.getDurable(),
					false, JmsConfig.getAutoDelete(), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("init queue producer connection error, taskQueueName:"
					+ taskQueueName, e);
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param messager 消息体
	 * @param retryTime 设置尝试重新连接的次数，-1为可以尝试无数次
	 * @return
	 */
	public boolean sendMessager(byte[] messager, int retryTime) {
		log.info("send messsager");
		try {
			//设置消息持久化，点对点模型中的转发器默认为""
			channel.basicPublish("", taskQueueName,
					MessageProperties.PERSISTENT_TEXT_PLAIN, messager);
			return true;
		} catch (ShutdownSignalException e) {
			log.error("send messager error,ShutdownSignalException", e);
			reConnection(5000L);
			if (retryTime-- > 0 || retryTime == -1) {
				sendMessager(messager, retryTime);
			}
		} catch (IOException e) {
			log.error("send messager error,IOException", e);
			if (retryTime-- > 0 || retryTime == -1) {
				sendMessager(messager, retryTime);
			}
		}
		return false;
	}

	/*
	 * 关闭连接
	 */
	public void closeConnection() {
		log.info("close queue producer connection, taskQueueName:"
				+ taskQueueName);
		if (channel != null || channel.isOpen()) {
			try {
				channel.close();
			} catch (IOException e) {
				log.error("close mq channel error", e);
			}
		}
		if (connection != null || connection.isOpen()) {
			try {
				connection.close();
			} catch (IOException e) {
				log.error("close mq connection error", e);
			}
		}
	}

	/**
	 * 重新连接
	 * 
	 * @param retryTime
	 */
	public void reConnection(Long retryTime) {
		try {
			Thread.sleep(retryTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (connection != null || connection.isOpen()) {
			closeConnection();
			initConnection();
		}
	}
}
