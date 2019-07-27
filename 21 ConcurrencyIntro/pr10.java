package chapter21_concurrency;

import java.util.Random;
import java.util.concurrent.*;
//在方法内部創建綫程 練習5的延申

public class pr10 {
	private Callable<Long> thread;

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

	public Future<Long> runTask(int n) {
		if (thread == null) {
			thread = new Callable<Long>() {

				public Long call() {
					return produceSum(n);
				}

			};
		}
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Long> result = executorService.submit(thread);
		executorService.shutdown();
		return result;
	}

	public static void main(String args[]) {
		for (int i = 0; i < 10; ++i) {
			int temp = new Random().nextInt(10) + 1;
			Future<Long> resultFuture = (new pr10().runTask(temp));
			try {
				System.out.println("斐波那契數列前" + temp + "項的和是：");
				System.out.println(resultFuture.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
