package com.hyc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description IO字符输入输出流测试
 * @createtime 2017年11月27日 下午2:38:09
 * @email cyhua_csu@163.com
 * @song 平凡之路
 */
public class TestCharStream {

	public static void main(String[] args) {
		TestCharStream tcs = new TestCharStream();
		String res1 = tcs
				.readFile1("C:\\Users\\huayingcao.HIK\\Desktop\\云存储\\appLicense.txt");
		System.out.println("循环读取方式：" + res1);
		String res2 = tcs
				.readFile2("C:\\Users\\huayingcao.HIK\\Desktop\\云存储\\appLicense.txt");
		System.out.println("直接读取方式：" + res2);

		String res3 = tcs
				.readFile3("C:\\Users\\huayingcao.HIK\\Desktop\\云存储\\appLicense.txt");
		System.out.println("全部读取方式：" + res3);
		String filePath = "D:\\FileDes\\test.txt";
		tcs.writeFile(filePath, "Hello World!");
		String res4 = tcs.readFile1(filePath);
		System.out.println("写入的内容是：" + res4);
		// 字符流只能操作纯文本，对图片操作时失真
		tcs.copyFile("D:\\FileSrc\\outdoor.jpg", "D:\\FileDes\\outdoor2.jpg");
		tcs.copyFile("D:\\FileSrc\\test.txt", "D:\\FileDes\\test.txt");
	}

	/**
	 * 读取文件:循环读取方式
	 * 
	 * @param filePath
	 * @return
	 */
	public String readFile1(String filePath) {
		String res = "";
		FileReader reader = null;
		try {
			File file = new File(filePath);
			reader = new FileReader(file);
			int size = (int) file.length();
			// 当字符数组的长度小于文件的长度时，会抛出ArrayIndexOutOfBoundsException
			// char[] charArray = new char[1024];
			char[] charArray = new char[size];
			int temp = 0;
			int len = 0;
			while ((temp = reader.read()) != -1) {
				charArray[len] = (char) temp;
				len++;
			}
			res = new String(charArray, 0, len);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * 读取文件：一次性读取方式
	 * 
	 * @param filePath
	 * @return
	 */
	public String readFile2(String filePath) {
		String res = "";
		FileReader reader = null;
		File file = new File(filePath);
		try {
			reader = new FileReader(file);
			// 当字符数组的长度小于文件大小时，不会抛出ArrayIndexOutOfBoundsException,但是只能读取指定长度的文件内容
			// char[] charArray = new char[1024];
			char[] charArray = new char[(int) file.length()];
			int len = reader.read(charArray);
			res = new String(charArray, 0, len);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * 读取文件：一次性读取全部方式
	 * 
	 * @param filePath
	 * @return
	 */
	public String readFile3(String filePath) {
		String res = "";
		FileReader reader = null;
		BufferedReader br = null;
		File file = new File(filePath);
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);

			// 使用do{}while(br.read() != -1)时会读取所有内容；使用while(br.read() !=
			// -1)时会丢失第一个字符,所以使用(buffer = br.readLine()) != null的方式读取
			// do {
			// res += br.readLine();
			// } while (br.read() != -1);
			String buffer = "";
			while ((buffer = br.readLine()) != null) {
				res += buffer;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * 向文件写入内容
	 * 
	 * @param filePath
	 * @param msg
	 * @return
	 */
	public void writeFile(String filePath, String msg) {
		FileWriter writer = null;
		try {
			// 获取字符输出流对象
			writer = new FileWriter(filePath);
			// 向输出流写入内容
			writer.write(msg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 不关闭输入流的情况下，写入文件的内容为空
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param srcFile
	 * @param desFile
	 */
	public void copyFile(String srcFile, String desFile) {
		FileReader reader = null;
		FileWriter writer = null;
		File file = new File(srcFile);
		try {
			// 获取字符输入流对象
			reader = new FileReader(file);
			// 创建文件大小的字符数组
			char[] charArray = new char[(int) file.length()];
			// 将文件中的内容读到字符数组中
			reader.read(charArray);
			// 获取字符输出流对象
			writer = new FileWriter(desFile);
			// 向输出流写从输入流获取到的文件内容
			writer.write(charArray);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 不关闭输入流时读取到的数据为空
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 不关闭输出流时写入文件的内容为空
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
