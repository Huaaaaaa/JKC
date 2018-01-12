package com.hyc.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool 定长线程池
 * 
 * @createtime 2017年9月19日 下午5:22:13
 * @description
 */
public class TestFixedThread {
	ExecutorService pool = Executors.newFixedThreadPool(3);

	/**
	 * 使用線程方法測試
	 */
	public void getIndexByThread() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			final int index = i;
			pool.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(index);
					// try {
					// Thread.sleep(2000);
					// } catch (InterruptedException e) {
					// System.out.println(e.getMessage());
					// }
				}
			});
		}
		long end = System.currentTimeMillis();
		System.out.println("线程方法耗时:" + (end - start));
	}

	/**
	 * 普通方法測試
	 */
	public void getIndex() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("普通方法耗时:" + (end - start));
	}
}