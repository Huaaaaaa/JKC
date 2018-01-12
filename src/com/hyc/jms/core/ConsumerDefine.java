package com.hyc.jms.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义消费者注解类 默认的队列名称、队列类型和消费者数量，即一个消费者创建一个连接
 * 
 * @author huayingcao
 *
 */
@Documented
@Inherited
@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ConsumerDefine {

	/*
	 * 队列名称,默认"hyc-default"
	 */
	public abstract String name() default "hyc-default";

	/*
	 * 队列类型,默认QUEUE
	 */
	public abstract MessagerType type() default MessagerType.QUEUE;

	/*
	 * 消费者数量，默认1
	 */
	public abstract int number() default 1;
}
