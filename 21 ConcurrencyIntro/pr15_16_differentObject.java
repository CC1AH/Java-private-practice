package chapter21_concurrency;

import java.util.concurrent.TimeUnit;

//��ʾ�����������ͬһ������Ĳ�ͬ���� �ٽ�����ͬ������²����ᷢ������
class ThreeSynch {
	private Object syncObject = new Object();
	private ThreeSynch innerCopySynch;

	// �ڱ�������ͬ�� ���൱��synchronized(this)��
	public synchronized void f() {
		while (true) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	// ������������ͬ������������������
	public void g() {

		synchronized (syncObject) {
			while (true) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}

	// ������������ͬ������ʹ��ͬһ���� Ҳ��������ͬ����ͬ����
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
