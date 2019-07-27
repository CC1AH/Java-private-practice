package chapter21_concurrency;

import java.util.concurrent.*;

//熟悉synchronized 完成兩個類修復
//聯係12 修復Atomicity.java
class Atomicity {
	static int i = 0;

	synchronized int f1() {
		i++;
		return i;
	}

	synchronized int f2() {
		i += 3;
		return i;
	}
}

//任務：依次運行f1 f2打印i的值
class AtomicityTask implements Runnable {
	private Atomicity atomicity;
	private static int count = 1;
	private final int id = count++;

	public AtomicityTask(Atomicity atomicity) {
		this.atomicity = atomicity;
	}

	@Override
	public void run() {
		// System.out.println(id + ": " + Thread.currentThread().getName() + " " +
		// atomicity.f1());
		System.out.println(id + ": " + Thread.currentThread().getName() + "  " + atomicity.f2());
	}
}

//練習13 修復SerialNumberChecker，演示不同线程如何安全地对同一种容器进行递增和检查操作
class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	public synchronized static int nextSerialNumber() {
		return serialNumber++;
	}
}

class CircularSet {
	// 圓角集合
	private int[] array;
	private int len;
	private int index = 0;

	public CircularSet(int size) {
		array = new int[size];
		len = size;
		for (int i = 0; i < size; i++)
			array[i] = -1;
	}

	public synchronized void add(int i) {
		array[index] = i;
		// 循環地向數組中寫入數字
		index = ++index % len;
	}

	public synchronized boolean contains(int val) {
		for (int i = 0; i < len; i++)
			if (array[i] == val)
				return true;
		return false;
	}
}

public class pr12_13 {
	private static CircularSet serials = new CircularSet(1000);

	static class SerialChecker implements Runnable {
		public void run() {
			while (true) {
				int serial = SerialNumberGenerator.nextSerialNumber();
				if (serials.contains(serial)) {
					System.out.println("生成了副本： " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		/*
		 * //practice 12 ExecutorService exec = Executors.newCachedThreadPool();
		 * //每一個任務在同一個對象上有序進行 Atomicity aimAtomicity = new Atomicity(); for (int i = 0;
		 * i < 20; i++) { exec.execute(new AtomicityTask(aimAtomicity)); }
		 * exec.shutdown();
		 */
		// practice 13
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++)
			executorService2.execute(new SerialChecker());
		TimeUnit.SECONDS.sleep(10);
		System.out.println("没有副本被检测到");
		//删去任意一个synchronized 这句话被打印的可能性就微乎其微
		System.exit(0);
	}
}
