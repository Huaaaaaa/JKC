package com.hyc.jms.test;

import java.util.List;

import com.hyc.jms.JmsInit;
import com.hyc.jms.core.MessagerHandler;
import com.hyc.jms.core.PkgUtils;
import com.hyc.jms.send.JmsSendKit;

public class Test {

	public static void main(String[] args) {
		testSender();
		testReceiver();
	}

	/*
	 * 发送程序
	 */
	public static void testSender() {
		JmsInit jmsInit = JmsInit.getInstance();
		jmsInit.initSender();

		JmsSendKit.queueSender("queue-test", "hello world".getBytes());
		JmsSendKit.queueSender("queue-test", "王尼玛是大坏蛋".getBytes());
		JmsSendKit.queueSender("queue-test", "@#￥（*……&%".getBytes());

		JmsSendKit.topicSender("topic-test", "wangzhipeng".getBytes());
		JmsSendKit
				.topicSender("topic-test", "隔壁老王明天就要来啦￥%%&%……&……*".getBytes());
		jmsInit.closeProducerConn();
		System.exit(0);
	}

	/*
	 * 接受程序
	 */
	public static void testReceiver() {
		JmsInit jmsInit = JmsInit.getInstance();
		try {
			List<Class<? extends MessagerHandler>> clzs = PkgUtils
					.getClassUnderPkg("com.hyc.jms.receive");
			jmsInit.initReceiver(clzs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
