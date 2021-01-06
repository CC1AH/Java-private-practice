package Composite;

import javax.swing.JOptionPane;

/**
 * it is easy for you to figure out composite pattern if you are familiar
 * with the use of composition in java. the only one thing that you might
 * be in chaos is difference between containers and concrete subject, remember
 * that only the lowest is the concrete, otherwise it is containers(may contain
 * other containers or the concrete--that is to mean the component itself) 
 *
 * Simple Description: The pattern just describes a tree with many branches and leaves. 
 *
 * @author CC1AH
 * @since 2019/6/27
 */
public class Begin_Component {
	public void operation() {
		JOptionPane.showConfirmDialog(null, "Component is displayed", "Tree", JOptionPane.OK_CANCEL_OPTION);
	}
}
