package com.hyc.jms.test;

import com.hyc.jms.core.ConsumerDefine;
import com.hyc.jms.core.MessagerHandler;
import com.hyc.jms.core.MessagerType;

public class TestQueueHandler implements MessagerHandler {

	@Override
	@ConsumerDefine(name = "test-queue", type = MessagerType.QUEUE, number = 2)
	public void handleMessager(byte[] messager) {
		System.out.println("TestQueueHandler" + new String(messager));
	}
}
