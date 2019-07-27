package chapter21_concurrency;

import static chapter21_concurrency.Daemon.printnb;
import java.util.concurrent.*;
//����ϰ7����֤��̨���̵��������Ǻ�̨���� 
//����ϰ8����֤��̨���̻������һ���Ǻ�̨���̵Ľ����������˳�����ʹ��finally�Ӿ�Ҳ������˲����У�

//Practice 7
class Daemon implements Runnable {
	public static void printnb(Object s) {
		System.out.println(s);
	}

	private Thread[] t = new Thread[10];

	public void run() {
		// �{��10���a���΄�
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			printnb("DaemonSpawn " + i + " started, ");
		}
		// �Д����_�M��
		for (int i = 0; i < t.length; i++)
			printnb("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		while (true)
			Thread.yield();
	}
}

//�M�̵Įa���΄գ��������΄ձ��{�Õr�a����
class DaemonSpawn implements Runnable {
	public void run() {
		while (true)
			Thread.yield();
	}
}

//Practice 8
//ע���½��̵߳���һ�ַ�ʽ
class SimpleThread extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public SimpleThread() {
		// Store the thread name:
		super(Integer.toString(++threadCount));
	}

	public String toString() {
		return "#" + getName() + "(" + countDown + "), ";
	}

	public void run() {
		try{
			while (true) {
				TimeUnit.SECONDS.sleep(3);	
			System.out.print(this);
			if (--countDown == 0)
				return;
			}
		}
		 catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				printnb("final block called");
			}
	}
}

public class pr7_8 {
	public static void main(String[] args) throws InterruptedException {
		/*
		
		// ��ϰ7����
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		printnb("d.isDaemon() = " + d.isDaemon() + ", ");
		// �����̨���������������̨���̼��������������2��
		TimeUnit.SECONDS.sleep(2);/
		
		*/

		// ��ϰ8����
		Thread d[] = new Thread[5];
		for(int i=0;i<d.length;++i) {
		    d[i] = new SimpleThread();
		    d[i].setDaemon(true);
		    d[i].start();
		}
		TimeUnit.SECONDS.sleep(7);
		//ע��final block �����õĴ���
	}
}
