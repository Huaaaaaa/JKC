package com.hyc.jms.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Handler;

import com.hyc.jms.JmsInit;
import com.hyc.jms.core.ConsumerDefine;
import com.hyc.jms.core.MessagerHandler;

/**
 * jms消费者初始化总类
 * 
 * @author huayingcao
 *
 */
public class JmsReceiver {
	private List<BasicConsumer> tasks = null;// 消费者
	private List<Class<? extends MessagerHandler>> handlers = null;

	public void setHanlders(List<Class<? extends MessagerHandler>> handlers) {
		this.handlers = handlers;
	}

	// 初始化消费者
	public void startAll() {
		if (handlers == null || handlers.size() == 0) {
			return;
		}
		tasks = new ArrayList<BasicConsumer>();
		MessagerHandler handlerInstance = null;
		for (Class<? extends MessagerHandler> handler : handlers) {
			ConsumerDefine annotation = null;
			try {
				annotation = handler.getDeclaredMethod("handleMessager",
						byte[].class).getAnnotation(ConsumerDefine.class);
				if (annotation == null) {
					annotation = MessagerHandler.class.getDeclaredMethod(
							"handlerMessager", byte[].class).getAnnotation(
							ConsumerDefine.class);
				}
				handlerInstance = handler.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (annotation == null || handlerInstance == null) {
				continue;
			}

			for (int i = 0; i < annotation.number(); i++) {
				switch (annotation.type()) {
				case QUEUE: {
					tasks.add(new QueueConsumer(annotation.name(),
							handlerInstance));
					break;
				}
				case TOPIC: {
					tasks.add(new TopicSubscriber(annotation.name(),
							handlerInstance));
					break;
				}
				default:
					tasks.add(new QueueConsumer(annotation.name(),
							handlerInstance));
					break;
				}
			}
		}
		ExecutorService pools = JmsInit.getInstance().getPools();
		for (BasicConsumer task : tasks) {
			pools.execute(task);
		}
	}

	public void closeAllConn() {
		if (tasks == null || tasks.size() == 0) {
			return;
		}
		for (BasicConsumer task : tasks) {
			task.closeConnection();
		}
	}

}
