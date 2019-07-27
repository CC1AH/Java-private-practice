package chapter21_concurrency;

import java.util.concurrent.TimeUnit;

//演示三个任务进入同一个对象的不同方法 临界区不同的情况下并不会发生堵塞
class ThreeSynch {
	private Object syncObject = new Object();
	private ThreeSynch innerCopySynch;

	// 在本对象上同步 （相当于synchronized(this)）
	public synchronized void f() {
		while (true) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	// 在其他对象上同步（其他对象被锁定）
	public void g() {

		synchronized (syncObject) {
			while (true) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}

	// 在其他对象上同步（即使是同一个类 也被视作不同对象同步）
	public void h() {
		innerCopySynch = new ThreeSynch();
		synchronized (innerCopySynch) {
			while (true) {
				System.out.println("h()");
				Thread.yield();
			}
		}
	}
}

public class pr15_16_differentObject {
	public static void main(String args[]) {
		final ThreeSynch threeSynch = new ThreeSynch();
		new Thread() {
			public void run() {
				threeSynch.f();
			}
		}.start();
		new Thread() {
			public void run() {
				threeSynch.g();
			}
		}.start();
		new Thread() {
			public void run() {
				threeSynch.h();
			}
		}.start();
		try {
			TimeUnit.SECONDS.sleep(5);
			System.exit(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
