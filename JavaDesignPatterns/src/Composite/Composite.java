package Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Composite extends Begin_Component implements Iterable{
	private List<Begin_Component> components = new ArrayList<Begin_Component>();

	public void add(Begin_Component component) {
		components.add(component);
	}

	public void remove(Begin_Component component) {
		components.remove(component);
	}

	@Override
	public void operation() {
		JOptionPane.showConfirmDialog(null, "Composite is displayed", "Composite", JOptionPane.OK_CANCEL_OPTION);
	}

	@Override
	public Iterator iterator() {
		return components.iterator();
	}
}
