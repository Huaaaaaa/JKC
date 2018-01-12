package com.hyc.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description Java 字节输入输出流测试
 * @createtime 2017年11月27日 下午2:31:37
 * @email cyhua_csu@163.com
 * @song 平凡之路
 */
public class TestByteStream {

	public static void main(String[] args) {
		TestByteStream tis = new TestByteStream();
		// String filePath = "D:\\FileSrc\\test.txt";
		// String msg = "Hello Worldddddd!";
		// System.out.println("向文件写入的内容是：" + msg);
		// tis.writeFile(filePath, msg);
		// String re1s = tis
		// .readFile1("C:\\Users\\huayingcao.HIK\\Desktop\\云存储\\appLicense.txt");
		String res2 = tis
				.readFile1("C:\\Users\\huayingcao.HIK\\Desktop\\云存储\\appLicense.txt");
		System.out.println("读取到的文件内容是:" + res2);
		// msg += "追加之后的内容啊啊啊啊啊啊";
		// tis.writeFile(filePath, msg);
		// res = tis.readFile1(filePath);
		// System.out.println("读取到的文件内容是:" + res);
		// tis.copyFile("D:\\FileSrc\\outdoor.jpg",
		// "D:\\FileDes\\outdoor1.jpg");

		// tis.writeFile2(filePath, msg);
	}

	/**
	 * 从文件读取
	 * 
	 * @param filePath
	 * @return
	 */
	public String readFile1(String filePath) {
		String result = "";
		FileInputStream fis = null;
		try {
			// 创建一个输入流对象
			fis = new FileInputStream(new File(filePath));
			System.out.println(fis.getFD().toString());
			// 获取可读取的大小
			int size = fis.available();
			// 创建size大小的字节数组,如果指定数组大小小于文件大小，虽然不会报数组越界的异常，但是只能读取指定大小的内容
			// byte[] arr = new byte[1024];
			byte[] arr = new byte[size];
			// 将文件中的内容读取到字节数据数组中
			fis.read(arr);
			// 将字节数组转化成字符串输出
			result = new String(arr, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String readFile2(String filePath) {
		String res = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			int read = 0;
			byte[] byteArray = new byte[1024];
			do {
				fis.read(byteArray);
			} while ((read = fis.read()) != -1);
			res = new String(byteArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 向文件中写入
	 * 
	 * @param filePath
	 * @param msg
	 */
	public void writeFile(String filePath, String msg) {
		FileOutputStream fos = null;
		try {
			// 获取输出流对象
			fos = new FileOutputStream(new File(filePath), true);// true表示内容可以追加
			// 将写入字符串转化成字节数组
			byte[] byteArr = msg.getBytes();
			// 向文件写入字节数组
			/**
			 * byte[] b 被写数组 int off 被写数组偏移量（从0开始） int len
			 * 写入文件的内容长度：改长度<=被写数组长度-off，否则数组越界，因为截取掉off个字节之后，剩余长度为总长度-off
			 */
			fos.write(byteArr, 2, byteArr.length - 2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 使用字节数组流的形式写入
	 * 
	 * @param filePath
	 * @param msg
	 */
	public void writeFile2(String filePath, String msg) {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			baos.write(msg.getBytes());
			System.out.println("字节数组流：" + baos.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实现文件的复制功能
	 * 
	 * @param srcFile
	 * @param desFile
	 */
	public void copyFile(String srcFile, String desFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 获取文件的输入流
			fis = new FileInputStream(srcFile);
			// 返回该输入流中可以被读取的字节大小
			int size = fis.available();
			// 创建size大小的字节数组
			byte[] byteArray = new byte[size];
			// 向字节数组读取文件内容
			fis.read(byteArray);

			// 创建文件输出流对象
			fos = new FileOutputStream(desFile);
			// 将字节数组中的内容写入输出流
			fos.write(byteArray);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
