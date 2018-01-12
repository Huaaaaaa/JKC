package com.hyc.jms.receive;

import org.apache.log4j.Logger;

import com.hyc.jms.core.ConsumerDefine;
import com.hyc.jms.core.MQHandlerFactory;
import com.hyc.jms.core.MessagerHandler;
import com.hyc.jms.core.MessagerType;

public class WeiXinQueueHandler implements MessagerHandler {
	Logger log = Logger.getLogger(WeiXinQueueHandler.class);

	@Override
	@ConsumerDefine(name = "weixin", type = MessagerType.QUEUE, number = 2)
	public void handleMessager(byte[] messager) {
		String msg = messager.toString();
		log.debug("handle weinxin messager");
		MQHandlerFactory.handlerWinXin(msg);
	}

}
