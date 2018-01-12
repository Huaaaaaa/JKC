package com.hyc.jms.send;

import org.apache.log4j.Logger;

import com.hyc.jms.producer.JmsSender;

public class JmsSendKit {
	private static Logger log = Logger.getLogger(JmsSendKit.class);

	private static JmsSender jmsSender;

	public static void init(JmsSender sender) {
		JmsSendKit.jmsSender = sender;
	}

	
	/**
	 *向消费者队列发送消息
	 * @param taskQueueName
	 * @param messager
	 * @return
	 */
	public static boolean queueSender(String taskQueueName, byte[] messager) {
		log.debug("request send queue msg:" + messager + ",to taskQueueName:"
				+ taskQueueName);
		return jmsSender.queueSend(taskQueueName, messager, 0);
	}

	/**
	 * 向发送者队列发送消息，失败后重新发送
	 * @param taskQueueName
	 * @param messager
	 * @param retryTime 尝试重新发送的次数，-1为无数次
	 * @return
	 */
	public static boolean queueSender(String taskQueueName, byte[] messager,
			int retryTime) {
		log.debug("request send queue msg:" + messager + ",to taskQueueName:"
				+ taskQueueName + ",reSend time:" + retryTime);
		return jmsSender.queueSend(taskQueueName, messager, retryTime);
	}

	/**
	 * 向消费者路由发送消息
	 * @param exchangeName
	 * @param messager
	 * @return
	 */
	public static boolean topicSender(String exchangeName, byte[] messager) {
		log.debug("request send topic msg:" + messager + ",to exchangeName:"
				+ exchangeName);
		return jmsSender.topicSend(exchangeName, messager, 0);
	}

	/**
	 * 向消费者路由发送消息，失败后重发
	 * @param exchangeName
	 * @param messager
	 * @param retryTime 尝试重发的次数，-1为无数次
	 * @return
	 */
	public static boolean topicSender(String exchangeName, byte[] messager,
			int retryTime) {
		log.debug("request send topic msg:" + messager + ",to exchangeName:"
				+ exchangeName + ",reSend time:" + retryTime);
		return jmsSender.topicSend(exchangeName, messager, retryTime);
	}
}
