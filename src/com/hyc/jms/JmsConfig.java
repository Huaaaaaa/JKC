package com.hyc.jms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jms连接参数的配置
 * @author huayingcao
 *
 */
public class JmsConfig {

	public interface Default {
		public static final String HOST = "localhost";
		public static final Integer PORT = 5672;
		public static final String USERNAME = "guest";
		public static final String PASSWORD = "guest";
		public static final boolean DURABLE = false;
		public static final boolean AUTO_DELETE = false;
	}

	private static final Properties properties = new Properties();

	public static synchronized void init(String resourceLocation) {
		InputStream is = JmsPlugin.class.getClassLoader().getResourceAsStream(
				resourceLocation);
		if (is == null) {
			throw new RuntimeException("找不到属性文件" + resourceLocation);
		}
		try {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("找不到属性文件" + resourceLocation);
		}
	}

	public static int getInt(String key) {
		return Integer.parseInt(key);
	}

	public static String getStr(String key) {
		Object obj = properties.get(key);
		return obj == null ? "" : obj.toString();
	}

	public static boolean getBool(String key) {
		Object obj = properties.get(key);
		return obj == null ? false : Boolean.valueOf(obj.toString());
	}

	/*
	 * 获取rabbitmq主机
	 */
	public static String getHost() {
		return properties.get("rabbitmq.host") == null ? Default.HOST
				: JmsConfig.getStr("rabbitmq.host");
	}

	/*
	 * 获取rabbitmq端口号
	 */
	public static Integer getPort() {
		return properties.get("rabbitmq.port") == null ? Default.PORT
				: JmsConfig.getInt("rabbitmq.port");
	}

	/*
	 * 获取rabbitmq用户名
	 */
	public static String getUserName() {
		return properties.get("rabbitmq.username") == null ? Default.USERNAME
				: JmsConfig.getStr("rabbitmq.username");
	}

	/*
	 * 获取rabbitmq的密码
	 */
	public static String getPwd() {
		return properties.getProperty("rabbitmq.password") == null ? Default.PASSWORD
				: JmsConfig.getStr("rabbitmq.password");
	}

	/*
	 * 获取数据是否持久化
	 */
	public static boolean getDurable() {
		return properties.get("rabbitmq.durable") == null ? Default.DURABLE
				: JmsConfig.getBool("rabbitmq.durable");
	}

	/*
	 * 获取是否自动删除
	 */
	public static boolean getAutoDelete() {
		return properties.get("rabbitmq.auto-delete") == null ? Default.AUTO_DELETE
				: JmsConfig.getBool("rabbitmq.auto-delete");
	}
}
