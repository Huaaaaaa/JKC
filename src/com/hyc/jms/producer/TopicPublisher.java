package com.hyc.jms.producer;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hyc.jms.JmsConfig;
import com.hyc.jms.JmsConnection;
import com.hyc.jms.core.ExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 订阅者/发布者模型生产者
 * 
 * @author huayingcao
 *
 */
public class TopicPublisher {

	private Logger log = Logger.getLogger(TopicPublisher.class);

	private static String exchangeName = null;
	private static Connection connection = null;
	private static Channel channel = null;

	@SuppressWarnings("static-access")
	public TopicPublisher(String exchangeName) {
		this.exchangeName = exchangeName;
		initConection();
	}

	/**
	 * 初始化连接信息
	 */
	public void initConection() {
		log.info("init topic publisher,exchangeName:" + exchangeName);
		JmsConnection jc = new JmsConnection();
		try {
			connection = jc.getConnection();
			channel = connection.createChannel();
			/*
			 * 声明转发器和类型，FANOUT为广播类型
			 */
			channel.exchangeDeclare(exchangeName, ExchangeType.FANOUT.getCode());

		} catch (IOException e) {
			log.error("init topic publisher error,exchangeName:" + exchangeName);
		}
	}

	/*
	 * 发送消息
	 */
	public boolean sendMessager(byte[] messager, int retryTime) {
		try {
			/*
			 * 往转发器上发送消息,exchangeName为routingKey
			 */
			channel.basicPublish(exchangeName, "", null, messager);
			return true;
		} catch (ShutdownSignalException e) {
			log.error("send messager error,ShutdownSignalException", e);
			reConnection(5000L);
			if (retryTime-- > 0 || retryTime == -1) {
				sendMessager(messager, retryTime);
			}
		} catch (IOException e) {
			log.error("send messager error,IOException", e);
			reConnection(5000L);
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
		log.info("close topic publisher channel");
		if (channel != null || channel.isOpen()) {
			try {
				channel.close();
			} catch (IOException e) {
				log.error("close topic publisher channel error");
			}
		}
		log.info("close topic publisher connection");
		if (connection != null | connection.isOpen()) {
			try {
				connection.close();
			} catch (IOException e) {
				log.error("close topic publisher connection error");
			}
		}
	}

	/*
	 * 重新连接
	 */
	public void reConnection(Long retryTime) {
		try {
			Thread.sleep(retryTime);
		} catch (InterruptedException e) {
		}
		if (connection != null || connection.isOpen()) {
			closeConnection();
			initConection();
		}
	}

}
