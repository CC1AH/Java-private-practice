package NormalFactory;
/**
 * Factory Method is known as Creational pattern, it is used to construct
 * objects such that they can be decoupled from the implementing system.
 * 
 * Simple Description: It defines an interface for creating an object. but
 * let the subclasses decide which class to instantiate.
 * The "Creator" hides the creation and instantiation of the "Product", which
 * benefit as they are now insulated from any future changes. It doesn't create
 * product actually, other methods only do operations.
 * @author CC1AH
 * @since 2019/6/6
 */
public interface Begin_Product {
	public void performProduct();
}
