package Composite;

import javax.swing.JOptionPane;

public class Leaf extends Begin_Component {
  @Override
  public void operation() {
	  JOptionPane.showConfirmDialog(null, "Leaf is displayed", "Leaf", JOptionPane.OK_CANCEL_OPTION);  
  }
}
