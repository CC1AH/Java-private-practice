package chapter21_concurrency;
import java.util.concurrent.*;
//修改綫程工廠，不使用在任務内部（run方法内）定義的方式定制綫程優先級：一般來説不要嘗試修改綫程優先級，請只改變屬性
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
