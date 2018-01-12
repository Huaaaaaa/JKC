package com.hyc.jms;

import java.io.IOException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * 创建Jms连接
 * @author huayingcao
 *
 */
public class JmsConnection {

	public Connection getConnection() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(JmsConfig.getHost());
		factory.setPort(JmsConfig.getPort());
		factory.setUsername(JmsConfig.getUserName());
		factory.setPassword(JmsConfig.getPwd());
		return factory.newConnection();
	}
}
