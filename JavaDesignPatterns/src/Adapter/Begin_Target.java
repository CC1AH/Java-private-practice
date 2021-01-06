package Adapter;

/**
 * An adapter pattern convert the interface of a class into another which client
 * expect. Adapters just let the classes work together that couldn't otherwise
 * because of incompatible interfaces. It is the solution to unavailable
 * portability.
 * 
 * Simple Description:The "Adapter" adapts the "Adaptee" to the "Target",
 * 
 * @author 15426
 * @since 2019/6/6
 */
public class Begin_Target {
	// class is often shown as interface in most tutorials to represent
	// a system. But it doesn't matter in performing. But what needs to 
	// be stressed is adapting only one class to work with another 
	// is really a weak example of the GoF Adapter pattern.
	public void targetMethod() {
		System.out.println("the method in target is called");
	}
}
