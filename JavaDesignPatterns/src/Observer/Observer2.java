package Observer;
import javax.swing.JOptionPane;
public class Observer2 extends Observer{
	public Observer2(Begin_Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		new JOptionPane().showMessageDialog(null,"observer 2:" + subject.getState());
	}
}
