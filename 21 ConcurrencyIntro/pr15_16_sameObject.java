package chapter21_concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import javax.swing.JOptionPane;

//演示臨界區和鎖的在同一對象上的使用 並展示在run方法中抛出的unchecked異常捕捉
class JOJO1 {
	Lock lock = new ReentrantLock();

	// Reentrant 可重入的
	// 显式加锁 不推荐（除非特殊用处（trylock或者捕获锁之类的） 否则还是使用synchronized块）
	public synchronized void f() throws InterruptedException {
		String stringJoTaran = "Ora";

		/*这里方法前还是使用了synchronized前缀，请去掉synchronized并运行程序，回答：交叉加锁能不能成功地在这个实例中完成同步任务？为什么？
		 * 答：不能，临界区（内置鎖）和显式锁机理不同，不能同时使用
		 */
		lock.lock();
		try {
			TimeUnit.SECONDS.sleep(1);
			int i = JOptionPane.showConfirmDialog(null, Thread.currentThread().getName() + " in method 1", "joTeRan",
					JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				for (int j = 0; j < 5; ++j) {
					System.out.print(stringJoTaran + "! ");
				}
				System.out.println("\n");
			}
		} finally {
			lock.unlock();
		}
	}

	// 运行该方法的部分时加锁
	public void g() throws InterruptedException {

		String stringJoSuki = "Dra";
		synchronized (this) {
			TimeUnit.SECONDS.sleep(1);
			int i = JOptionPane.showConfirmDialog(null, Thread.currentThread().getName() + " in method 2", "joSuKi",
					JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION)
				for (int j = 0; j < 5; ++j) {
					System.out.print(stringJoSuki + "! ");
				}
			System.out.println("\n");
		}
	}

	// 运行该方法时加锁
	public synchronized void h() throws InterruptedException {
		String stringJoRuno = "Muda";

		TimeUnit.SECONDS.sleep(1);
		int i = JOptionPane.showConfirmDialog(null, Thread.currentThread().getName() + " in method 3", "joRuNo",
				JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION)
			for (int j = 0; j < 5; ++j) {
				System.out.print(stringJoRuno + "! ");
			}
		System.out.println("\n");

	}
}

//嘗試處理由run抛出的異常的處理器
class ConcreteUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.println("caught " + e);
		e.printStackTrace();
	}

}

//任務
class JOJOmanipulator implements Runnable {
	private JOJO1 jojo = new JOJO1();
	private static int j = 0;

	public JOJOmanipulator(JOJO1 jojo1) {
		jojo = jojo1;
	}

	@Override
	public void run() {
		// throw new RuntimeException();//remove while blocks when you try this; let the
		// thread die or you won't see the affect of UnCaughtExceptionHandler
		while (true) {
			try {
				switch (j) {
				case 0:
					jojo.f();
					break;
				case 1:
					jojo.g();
					break;
				case 2:
					jojo.h();
				default:
					break;
				}
			} catch (InterruptedException e) {
				e.getMessage();
			}
			System.out.println("方法序號：" + j);
			/*
			 * 方法序號和方法匹配嗎？爲什麽？
			 * 答：注意觀察此處鎖的特性 雖然方法序號在輪回 但是j并沒有上鎖 每個綫程一開始便可以獲取j的值之後等待臨界區解鎖，
			 * 故每個綫程仍舊從等待前的j開始依次有序進行 所以此処并不是輪流運行三個方法 而是隨機的運行三個方法 隨機性取決於綫程的切換频率
			 */
			j = ((++j) % 3);
			Thread.yield();// 注意在while内部添加同步縣程切換提示以更好的看到效果 這只是一個提示
		}
	}
}

public class pr15_16_sameObject {
	private static JOJO1 jojo = new JOJO1();// 用於枷鎖的對象

	public static void main(String args[]) {
		Thread.setDefaultUncaughtExceptionHandler(new ConcreteUncaughtExceptionHandler());
		// run中異常捕获的最簡潔方法 設置一個默認异常處理器
		// 或者用new Thread(Runnable).setUncaughtExceptionHandler(eh);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; ++i) {
			executorService.execute(new JOJOmanipulator(jojo));
		}
		executorService.shutdown();
	}
}
