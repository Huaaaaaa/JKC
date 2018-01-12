package com.hyc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @description 缓冲流测试类
 * @createtime 2017年11月27日 下午8:04:33
 * @email cyhua_csu@163.com
 * @song 平凡之路
 */
public class TestBufferedStream {
	public static void main(String[] args) {
		TestBufferedStream tbs = new TestBufferedStream();
		String filePath = "D:\\FileSrc\\test-buffered.txt";
		String msgZN = "哈罗";
		String msgES = "hello";
		tbs.writeFile(filePath, msgZN);
		tbs.readFile(filePath);

		String code = System.getProperty("file.encoding");
		System.out.println(code);
	}

	/**
	 * 向指定文件写入消息
	 * 
	 * @param filePath
	 * @param msg
	 */
	public void writeFile(String filePath, String msg) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			bos.write(msg.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取文件
	 * 
	 * @param filePath
	 * @return
	 */
	public void readFile(String filePath) {
		String res = "";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			byte[] byteArray = new byte[1024];
			bis.read(byteArray);
			res = new String(byteArray);
			System.out.println("字节数组的长度是：" + byteArray.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("读取的内容是：" + res + ";\n读取的长度是："
				+ res.getBytes().length);
	}
}
