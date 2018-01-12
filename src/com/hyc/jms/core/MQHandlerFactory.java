package com.hyc.jms.core;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.hyc.jms.WinXin;
import com.hyc.jms.WinXinHandler;

public class MQHandlerFactory {
	private static Logger log = Logger.getLogger(MQHandlerFactory.class);

	public static void handlerWinXin(String msg) {
		try {
			WinXin wx = JSON.parseObject(msg, WinXin.class);
			if (StringUtils.isEmpty(msg)) {
				log.info("接受的微信消息不能为空");
				return;
			}

			Object obj = MQHandlerFactory.getInstance(wx.getClass().getName());
			if (obj == null) {
				log.error("不存在要处理的类");
			} else {
				((WinXinHandler) obj).handle(wx);
			}
		} catch (Exception e) {
			log.error("微信数据报错");
		}
	}

	private static Object getInstance(String className) {
		return MQHandlerFactory.getInstance(className);
	}
}
