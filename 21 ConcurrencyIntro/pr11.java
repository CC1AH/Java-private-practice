package chapter21_concurrency;

import java.util.concurrent.*;

//演示synchronized關鍵字的使用
abstract class DoubleGenerator {
	public abstract double next();
}

//任務：加數并且判斷是否在範圍内
class RangeChecker implements Runnable {
	private DoubleGenerator doubleGenerator;
	private final int id;

	public RangeChecker(DoubleGenerator doubleGenerator, int ident) {
		this.doubleGenerator = doubleGenerator;
		id = ident;
	}

	@Override
	public void run() {
		double val = doubleGenerator.next();
		if (val > 0.5) {
			System.out.println("#" + id + ": the number " + val + " is not in range *.0-*.5");
		}
	}

	public static void test(DoubleGenerator doubleGenerator, int count) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			executorService.execute(new RangeChecker(doubleGenerator, i));
		}
		executorService.shutdown();
	}
}

public class pr11 extends DoubleGenerator {
	//不加volatile 64位double可能发生字撕裂而導致單操作的原子性被破壞 然而加不加都要一定要考虑同步
	//在這裏，有同步防護（首選）下volatile關鍵字（優化）的使用是多餘的
	private volatile double currentEventValue = 0.0;

	// 对象枷鎖 --刪去關鍵字就不一定是6個不符合（多綫程并用）
	public synchronized double next() {
		
		currentEventValue += 0.005;
		Thread.yield();
		currentEventValue += 0.005;
		Thread.yield();
		currentEventValue += 0.01;
		return currentEventValue;
	}

	public static void main(String args[]) {
		RangeChecker.test(new pr11(), 30);
	}
}