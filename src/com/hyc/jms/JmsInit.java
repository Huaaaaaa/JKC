package com.hyc.jms;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;

import com.hyc.jms.consumer.JmsReceiver;
import com.hyc.jms.core.FixedAndBlockedThreadPoolExecutor;
import com.hyc.jms.core.MessagerHandler;
import com.hyc.jms.producer.JmsSender;
import com.hyc.jms.send.JmsSendKit;

public class JmsInit {
	private static final Logger log = Logger.getLogger(JmsInit.class);
	public static final String resourceLocation = "jms.properties";
	private static JmsSender sender = null;
	private static JmsReceiver receiver = null;
	private ExecutorService pools = null;

	public static JmsInit getInstance() {
		return SinglertonHolder.INSTANCE;
	}

	private static class SinglertonHolder {
		static JmsInit INSTANCE = new JmsInit();
	}

	public ExecutorService getPools() {
		return this.pools;
	}

	/**
	 * 初始化JMS消息配置及工具类
	 */
	private JmsInit() {
		log.info("加载JMS配置文件");
		JmsConfig.init(resourceLocation);
	}

	/**
	 * 初始化JMS生产者
	 */
	public void initSender() {
		log.info("初始化JMS生产者");
		sender = new JmsSender();
		JmsSendKit.init(sender);
	}

	/**
	 * 初始化JMS消费者
	 */
	public void initReceiver(List<Class<? extends MessagerHandler>> clzs) {
		log.info("初始化JMS消费者线程池");
		this.pools = new FixedAndBlockedThreadPoolExecutor(
				JmsConfig.getInt("rabbitmq.threads"));
		log.info("初始化JMS消费者");
		receiver = new JmsReceiver();
		receiver.setHanlders(clzs);
		receiver.startAll();
	}

	/*
	 * 关闭生产者连接
	 */
	public void closeProducerConn() {
		log.info("colse producer connection");
		if (sender != null) {
			sender.closeConn();
		}
	}

	/*
	 * 关闭消费者连接
	 */
	public void closeConsmerConn() {
		log.info("close consumer connectioin");
		if (receiver != null) {
			receiver.closeAllConn();
		}
	}
}
