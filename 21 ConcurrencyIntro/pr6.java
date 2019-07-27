package chapter21_concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//���������΄� �@ʾ���ߕr�g������run��yield���{�ÓQ��sleep���ɣ�
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
		//run�е�unchecked�����o����main���M�Ё�Դ׷ۙ�ģ�ֱ�ӵ������_�����o����׽ ���w��̎�����҂���������15_16
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
		}//����̎�������M���г��F
		executorService.shutdown();
	}
}
