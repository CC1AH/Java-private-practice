package chapter21_concurrency;
import java.util.concurrent.*;
//�޸ľQ�̹��S����ʹ�����΄��ڲ���run�����ڣ����x�ķ�ʽ���ƾQ�̃��ȼ���һ����h��Ҫ�Lԇ�޸ľQ�̃��ȼ���Ոֻ��׃����
class MaxProrityFactory implements ThreadFactory{
	public Thread newThread(Runnable r) {
		Thread thread= new Thread(r);
		thread.setPriority(Thread.MAX_PRIORITY);
		return thread;
	}
}
class MinPriorityFactory implements ThreadFactory{
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setPriority(Thread.MIN_PRIORITY);
		return thread;
	}
}
class SimplePriority implements Runnable{
	private int countDown = 5;
	private volatile double d;
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}
	public void run() {
		while(true) {
			for(int i=1;i<10000;++i) {
				d += (Math.E + Math.PI)/(double)i;
				if (i%1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if(--countDown == 0)
				return;
		}
	}
}
public class pr9 {
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newCachedThreadPool(new MinPriorityFactory());
		ExecutorService executorService2 = Executors.newCachedThreadPool(new MaxProrityFactory());
		for(int i=0;i<5;++i)
			executorService.submit(new SimplePriority());
		executorService2.submit(new SimplePriority());
		executorService.shutdown();
		executorService2.shutdown();
	}
}
