package chapter21_concurrency;

//��ʾTimer�������cʹ��
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import javax.swing.*;

//����TIMER
interface Generator<T> {
	T next();
}

class TheWorld implements Generator<Timer> {
	@Override
	public Timer next() {
		Timer timer = new Timer();
		return timer;
	}
}

//��ͬ��Timer�����΄�
public class pr14 {
	private static TheWorld theWorld = new TheWorld();

	public static void TimerTaskRunning(Timer timer) {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				while (true) {
					Frame frame = new JFrame("the world in " + Thread.currentThread().getName());
					frame.setLayout(new GridLayout(1, 3));
					frame.setBackground(Color.white);
					frame.add(new JLabel("����dio����"));
					frame.add(new JLabel("wryyyy!!!"));
					frame.add(new JLabel("����dio����"));
					try {
						TimeUnit.MILLISECONDS.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					frame.pack();
					frame.setVisible(true);
					frame.setSize(500, 500);
					JOptionPane.showMessageDialog(null, "�o�j�o�j�o�j�o�j�o�j��");
				}
			}
		}, 10000);
	}

	public static void main(String args[]) {
		for (int i = 0; i < 100; ++i) {
			TimerTaskRunning(theWorld.next());
		}
	}
}
