package Adapter;
/**
 * In order to obtain the target object directly by adapter and connect
 * "Adaptee", we let "Adapter" extends target and composed of Adaptee.
 * @author 15426
 * @since 2019/6/6
 */
public class Adapter extends Begin_Target{
	Adaptee AdapteeObject;
	public Adapter(Adaptee adaptee){
		AdapteeObject = adaptee;
	}
	
	/**
	 * the main method in an adapter. Target's method should be overridden 
	 * to give adaption to adaptee's methods at real need.
	 */
	@Override
	public void targetMethod() {
		AdapteeObject.adapteeMethod();
		System.out.println(", and it is adapted by Adapter.");
	}
}
