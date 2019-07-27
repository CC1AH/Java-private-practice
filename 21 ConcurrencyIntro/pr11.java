package chapter21_concurrency;

import java.util.concurrent.*;

//��ʾsynchronized�P�I�ֵ�ʹ��
abstract class DoubleGenerator {
	public abstract double next();
}

//�΄գ��Ӕ������Д��Ƿ��ڹ�����
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
	//����volatile 64λdouble���ܷ�����˺�Ѷ����β�����ԭ���Ա��Ɖ� Ȼ���Ӳ��Ӷ�Ҫһ��Ҫ����ͬ��
	//���@�Y����ͬ�����o�����x����volatile�P�I�֣���������ʹ���Ƕ��N��
	private volatile double currentEventValue = 0.0;

	// ������i --�hȥ�P�I�־Ͳ�һ����6�������ϣ���Q�̲��ã�
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