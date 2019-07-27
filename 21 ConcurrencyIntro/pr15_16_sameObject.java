package chapter21_concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import javax.swing.JOptionPane;

//��ʾ�R��^���i����ͬһ�����ϵ�ʹ�� �Kչʾ��run�������׳���unchecked������׽
class JOJO1 {
	Lock lock = new ReentrantLock();

	// Reentrant �������
	// ��ʽ���� ���Ƽ������������ô���trylock���߲�����֮��ģ� ������ʹ��synchronized�飩
	public synchronized void f() throws InterruptedException {
		String stringJoTaran = "Ora";

		/*���﷽��ǰ����ʹ����synchronizedǰ׺����ȥ��synchronized�����г��򣬻ش𣺽�������ܲ��ܳɹ��������ʵ�������ͬ������Ϊʲô��
		 * �𣺲��ܣ��ٽ����������i������ʽ������ͬ������ͬʱʹ��
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

	// ���и÷����Ĳ���ʱ����
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

	// ���и÷���ʱ����
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

//�Lԇ̎����run�׳��Į�����̎����
class ConcreteUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.println("caught " + e);
		e.printStackTrace();
	}

}

//�΄�
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
			System.out.println("������̖��" + j);
			/*
			 * ������̖�ͷ���ƥ��᣿��ʲ�᣿
			 * ��ע���^���̎�i������ �mȻ������̖��݆�� ����j���]�����i ÿ���Q��һ�_ʼ����ԫ@ȡj��ֵ֮��ȴ��R��^���i��
			 * ��ÿ���Q�����f�ĵȴ�ǰ��j�_ʼ���������M�� ���Դ˄I������݆���\���������� �����S�C���\���������� �S�C��ȡ�Q춾Q�̵��ГQƵ��
			 */
			j = ((++j) % 3);
			Thread.yield();// ע����while�ڲ����ͬ���h���ГQ��ʾ�Ը��õĿ���Ч�� �@ֻ��һ����ʾ
		}
	}
}

public class pr15_16_sameObject {
	private static JOJO1 jojo = new JOJO1();// ��춼��i�Č���

	public static void main(String args[]) {
		Thread.setDefaultUncaughtExceptionHandler(new ConcreteUncaughtExceptionHandler());
		// run�Ю��������������� �O��һ��Ĭ�J�쳣̎����
		// ������new Thread(Runnable).setUncaughtExceptionHandler(eh);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; ++i) {
			executorService.execute(new JOJOmanipulator(jojo));
		}
		executorService.shutdown();
	}
}
