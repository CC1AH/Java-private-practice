package chapter21_concurrency;
import java.util.Random;
import java.util.concurrent.*;
//演示基本的任务类与线程使用，并使用switch展示不同的执行器
class showMessage implements Runnable{
	private static int showCount = 0;
	private final int id = showCount++;
	public showMessage() {
		System.out.println("start message: " + id);
	}
	public  String toString() {
		return "Message" + id;
	}
	public void run() {
		for(int i=1;i<4;++i)
			//观察该消息的打印位置 它确定吗 与什么有关？
		System.out.print(this.toString() + "\n");
		Thread.yield();
			//观察进程的结束位置 它确定吗 与什么有关？
		System.out.println("end message2: " + id);
	}
}
public class pr1_3 {
	public static void main(String args[]) {
		/* normal way 
		for(int i=0;i<10;++i)
		new Thread(new showMessage()).start();
		*/
		ExecutorService executorService;
		int i = new Random(48).nextInt(3);
		switch (i) {
		case 0:
			executorService = Executors.newCachedThreadPool();
			System.out.println("Cached Thread Pool：Choose this first");
			break;
		case 1:
			executorService = Executors.newFixedThreadPool(5);
			System.out.println("Fixed Thread Pool：when the first met problem");
			break;
		case 2:
			executorService = Executors.newSingleThreadExecutor();
			System.out.println("Single Thread Pool：dealing with a thread always");
			break;
		default:
			executorService = null;
			break;
		}
		
		for(int j=0;j<10;++j) {
			executorService.execute(new showMessage());
		}
		executorService.shutdown();//防止新任务提交
	}
}
