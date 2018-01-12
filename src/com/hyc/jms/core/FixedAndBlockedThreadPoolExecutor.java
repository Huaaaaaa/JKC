package com.hyc.jms.core;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FixedAndBlockedThreadPoolExecutor extends ThreadPoolExecutor {

	/*
	 * 一个可重入的互斥锁
	 */
	final ReentrantLock lock = new ReentrantLock();
	final Condition condition = this.lock.newCondition();

	public FixedAndBlockedThreadPoolExecutor(int size) {
		super(size, size, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingDeque<Runnable>());
	}

	@Override
	public void execute(Runnable command) {
		// 同步锁定
		this.lock.lock();
		super.execute(command);

		try {
			if (getPoolSize() == getMaximumPoolSize()) {
				this.condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}

	}

	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		try {
			this.lock.lock();
			this.condition.signal();
		} finally {
			this.lock.unlock();
		}

	}

}
