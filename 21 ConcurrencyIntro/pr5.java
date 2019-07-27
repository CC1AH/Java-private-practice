package chapter21_concurrency;

import java.util.concurrent.*;
//使用Callable實現計算斐波那契數列前N項和的任務 該接口只能使用Submit調用
class SumofNfibonacci implements Callable<Long> {
	private int param = 0;

	private static long F(int m) {
		if (m == 0 || m == 1)
			return 1;
		else
			return F(m - 1) + F(m - 2);
	}

	private static long produceSum(int n) {
		long sum = 0;
		for (int i = 0; i < n; ++i)
			sum += F(i);
		return sum;
	}

	public SumofNfibonacci(int n) {
		param = n;
	}

	public Long call() {
		return produceSum(param);
	}

}

public class pr5 {
	public static void main(String args[]){
		ExecutorService executorService = Executors.newCachedThreadPool();
		// executorService.submit(task)返回一个Future对象，它用Call方法的返回类型进行了参数化
		// 本例中就是Future<Long>.用isDone()查询，用get()获得
		try {
			for (int i = 5; i < 15; ++i)
				System.out.println((executorService.submit(new SumofNfibonacci(i)).get()));
		} catch (InterruptedException e) {
			System.err.print(e);
		} catch (ExecutionException e) {
			System.err.print(e);
		} finally {
			executorService.shutdown();
		}//可能引发两种异常
	}

}
