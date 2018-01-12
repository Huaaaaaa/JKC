package com.hyc.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 
 * @description 管道流测试
 * @createtime 2017年11月27日 下午7:43:22
 * @email cyhua_csu@163.com
 * @song 平凡之路
 */
public class TestPipeStream {

	public static void main(String[] args) {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		sender.start();// 如果不启动发送线程，接受线程就会一直处于阻塞状态，直到有内容写入为止
		receiver.start();
	}

	static class Sender extends Thread {
		private PipedOutputStream pos = new PipedOutputStream();

		public PipedOutputStream getOut() {
			return this.pos;
		}

		public void run() {
			String msg = "Hello World!";
			try {
				pos.write(msg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Receiver extends Thread {
		private PipedInputStream pis;

		public Receiver(Sender sender) {
			try {
				pis = new PipedInputStream(sender.getOut());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			try {
				byte[] byteArray = new byte[1024];
				int read = 0;
				do {
					pis.read(byteArray);
				} while ((read = pis.read()) != -1);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
