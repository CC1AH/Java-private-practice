package Observer;
import javax.swing.JOptionPane;
public class Observer1 extends Observer{
	public Observer1(Begin_Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	@Override
	public void update() {
		JOptionPane jOptionPane = new JOptionPane();
		jOptionPane.showMessageDialog(null, "observer1:" + subject.getState());
	}

}
