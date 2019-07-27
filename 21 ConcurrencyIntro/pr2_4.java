package chapter21_concurrency;

import java.util.*;
import java.util.concurrent.*;
//ʹ�ò�ͬ�ľQ�̈��д�ӡ쳲��������е�ǰN헵��΄գ��Kʹ�ò����OӋģʽչʾ��ͬ�Ĉ�����
interface ExecutorStrategies {
	void excuteIt();
}

class CachStrategy implements ExecutorStrategies {

	@Override
	public void excuteIt() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		System.out.println("Cached Threads");
		for (int i = 5; i < 15; ++i) {
			executorService.execute(new produceFibonacci(i));
		}
		executorService.shutdown();
	}

}

class FixedStrategy implements ExecutorStrategies {
	@Override
	public void excuteIt() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		//��ע���Z��λ�ã�FixedThread�Ƿ���SingleThread�\����ɺ����_ʼ���@ȡ�Q�cʲ�᣿
		System.out.println("Fixed Threads");
		for (int i = 5; i < 15; ++i) {
			executorService.execute(new produceFibonacci(i));
		}
		executorService.shutdown();
	}
}

class SingleStrategy implements ExecutorStrategies {
	@Override
	public void excuteIt() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		System.out.println("Single Thread");
		for (int i = 5; i < 15; ++i) {
			executorService.execute(new produceFibonacci(i));
		}
		executorService.shutdown();
	}
}

class produceFibonacci implements Runnable {
	private static long F(int m) {
		if (m == 0 || m == 1)
			return 1;
		else
			return F(m - 1) + F(m - 2);
	}

	private int fibonacciParam;
	public LinkedList<Long> resultArrayList = new LinkedList<Long>();

	public produceFibonacci(int n) {
		fibonacciParam = n;
	}

	public void run() {
		int i = 0;
		while (i < fibonacciParam) {
			resultArrayList.add(F(i));
			++i;
		}
		System.out.println(resultArrayList + "     ");
		Thread.yield();
	}
}

public class pr2_4 {
	ExecutorStrategies executorStrategies;
	public pr2_4(ExecutorStrategies executorStrategies) {
		this.executorStrategies = executorStrategies;
	}
	public pr2_4 setExecutorStrategies(ExecutorStrategies executorStrategies) {
		this.executorStrategies = executorStrategies;
		return this;
	}
	public pr2_4 performExecutorStrategies() {
		executorStrategies.excuteIt();
		return this;
	}
	public static void main(String args[]) {
		/*
		 * normal way for (int i = 5; i < 15; ++i) new Thread(new
		 * produceFibonacci(i)).start();
		 */
		new pr2_4(new CachStrategy()).performExecutorStrategies()
		.setExecutorStrategies(new SingleStrategy()).performExecutorStrategies()
		.setExecutorStrategies(new FixedStrategy()).performExecutorStrategies();
	}
}
