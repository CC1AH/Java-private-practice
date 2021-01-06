package Composite;
/**
 * the design pattern of composite is used widely.
 * in java swing, checkbox and buttons are leaves and containers are branches.
 * algorithm expression include operate bit,operator and another operate bit,
 * an operator can have either or both of them, too...
 * 
 * an overall usage of the code above is as follows.
 * @author CC1AH
 * @since 2019/6/27
 */
public class Usage {
	public static void main(String args[]) {
		Composite branch = new Composite();
		branch.add(new Leaf());
		Composite tree = new Composite();
		tree.add(branch);
		tree.add(new Leaf());
		
		//display
		tree.operation();
		for(Object s:tree) {
			if(s instanceof Begin_Component)//owe to eraser
				((Begin_Component) s).operation();
		}
	}
}
