package com.hyc.jms;

import java.io.Serializable;

/**
 * 微信消息参数封装类
 * 
 * @author huayingcao
 *
 */
@SuppressWarnings("serial")
public class WinXin implements Serializable {

	public String senderId;// 发送者ID

	public String senderAddress;// 发送者所在位置

	public String sendTime;// 发送时间

	public String sendContent;// 发送内容

	public String contentResource;// 内容来源

	public String contentPublicNum;// 内容公众号

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getContentResource() {
		return contentResource;
	}

	public void setContentResource(String contentResource) {
		this.contentResource = contentResource;
	}

	public String getContentPublicNum() {
		return contentPublicNum;
	}

	public void setContentPublicNum(String contentPublicNum) {
		this.contentPublicNum = contentPublicNum;
	}

}
