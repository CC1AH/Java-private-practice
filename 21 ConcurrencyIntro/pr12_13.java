package chapter21_concurrency;

import java.util.concurrent.*;

//��Ϥsynchronized ��Ƀɂ���ޏ�
//�S12 �ޏ�Atomicity.java
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

//�΄գ������\��f1 f2��ӡi��ֵ
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

//����13 �ޏ�SerialNumberChecker����ʾ��ͬ�߳���ΰ�ȫ�ض�ͬһ���������е����ͼ�����
class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	public synchronized static int nextSerialNumber() {
		return serialNumber++;
	}
}

class CircularSet {
	// �A�Ǽ���
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
		// ѭ�h���򔵽M�Ќ��딵��
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
					System.out.println("�����˸����� " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		/*
		 * //practice 12 ExecutorService exec = Executors.newCachedThreadPool();
		 * //ÿһ���΄���ͬһ�������������M�� Atomicity aimAtomicity = new Atomicity(); for (int i = 0;
		 * i < 20; i++) { exec.execute(new AtomicityTask(aimAtomicity)); }
		 * exec.shutdown();
		 */
		// practice 13
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++)
			executorService2.execute(new SerialChecker());
		TimeUnit.SECONDS.sleep(10);
		System.out.println("û�и�������⵽");
		//ɾȥ����һ��synchronized ��仰����ӡ�Ŀ����Ծ�΢����΢
		System.exit(0);
	}
}
