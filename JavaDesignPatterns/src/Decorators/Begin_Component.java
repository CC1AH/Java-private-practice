package Decorators;

/**
 * The concept of decorator is that they adds additional attributes to an object
 * dynamically. The decorator pattern allows for the dynamic wrapping of objects
 * in order to modify their existing responsibilities and behaviors.
 * (A Vital Principle is obeyed: Classes should be open for extension, but closed 
 * for modification)
 * 
 * Simple Description:An interface is needed to integrated all the decorators and 
 * decoratees. The decorators often(always) appear as a group but we use only a 
 * class to represent the decorators in this example. Decorators use a decoratee 
 * object(a log) initialized in its constructor, and implement the pattern by add 
 * extensions in its overridden methods.
 * @author CC1AH
 * @since 2019/6/6
 */
public interface Begin_Component {
	public void methodsDecorated();
}
