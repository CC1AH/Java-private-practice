package chapter21_concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//創建休眠任務 顯示休眠時間（即將run中yield的調用換為sleep即可）
class SleepDemo implements Runnable {
	int countDown = 10;
	private static int countTask = 0;
	private final int id = ++countTask;
	private Random rand = new Random(47);
	@Override
	public void run() {
		while (countDown-- > 0)
		try {
			int re = rand.nextInt(10) + 1;
			TimeUnit.SECONDS.sleep(re);
			System.out.println("#id " + id + "-sleep for: " + re);
		}
		//run中的unchecked異常無法从main中進行來源追蹤從（直接到控制臺）而無法捕捉 具體的處理方法我們留到練習15_16
		catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
public class pr6 {
	public static void main(String args[]){
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<5;++i) {
			executorService.execute(new SleepDemo());
		}//異常處理不在主進程中出現
		executorService.shutdown();
	}
}
