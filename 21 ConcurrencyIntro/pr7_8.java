package chapter21_concurrency;

import static chapter21_concurrency.Daemon.printnb;
import java.util.concurrent.*;
//（练习7）验证后台进程的子任务是后台进程 
//（练习8）验证后台进程会随最后一个非后台进程的结束而立即退出（即使有finally子句也可以因此不執行）

//Practice 7
class Daemon implements Runnable {
	public static void printnb(Object s) {
		System.out.println(s);
	}

	private Thread[] t = new Thread[10];

	public void run() {
		// 調用10個產物任務
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			printnb("DaemonSpawn " + i + " started, ");
		}
		// 判斷後臺進程
		for (int i = 0; i < t.length; i++)
			printnb("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		while (true)
			Thread.yield();
	}
}

//進程的產物任務（在主干任務被調用時產生）
class DaemonSpawn implements Runnable {
	public void run() {
		while (true)
			Thread.yield();
	}
}

//Practice 8
//注意新建线程的另一种方式
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
		
		// 练习7测试
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		printnb("d.isDaemon() = " + d.isDaemon() + ", ");
		// 允许后台进程完成启动：后台进程及其子任务会运行2秒
		TimeUnit.SECONDS.sleep(2);/
		
		*/

		// 练习8测试
		Thread d[] = new Thread[5];
		for(int i=0;i<d.length;++i) {
		    d[i] = new SimpleThread();
		    d[i].setDaemon(true);
		    d[i].start();
		}
		TimeUnit.SECONDS.sleep(7);
		//注意final block 被调用的次数
	}
}
