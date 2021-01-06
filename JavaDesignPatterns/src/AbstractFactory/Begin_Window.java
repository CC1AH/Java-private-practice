package AbstractFactory;

/**
 * This Pattern Provides an interface for creating families of related or
 * dependent objects without specifying their concrete classes.
 * 
 * Simple Description:The AbstractFactory defines the interface that all of the
 * concrete factories will need to implement in order to product Products.
 * ConcreteFactoryA and ConcreteFactoryB have both implemented this interface
 * here, creating two separate FAMILIES of product. Meanwhile, AbstractProductA
 * and AbstractProductB are interfaces for the different types of product. Each
 * factory will create one of each of these AbstractProducts.
 * 
 * The Client deals with AbstractFactory, AbstractProductA and AbstractProductB.
 * It doesn't know anything about the implementations. The actual implementation
 * of AbstractFactory that the Client uses is determined at runtime.The client
 * is totally decoupled from the concrete products. Also, new product families
 * can be easily added into the system, by just adding in a new type of
 * ConcreteFactory that implements AbstractFactory, and creating the specific
 * Product implementations.
 * 
 * This Time, we will use a real example of UI toolkits to implement our
 * tutorial. Then you can see, the abstract factory is essentially the same as
 * the factory method but differs in the control structures.
 * 
 * @author CC1AH
 * @since 2019/6/6
 */
public interface Begin_Window {
	public void setTitle(String text);

	public void repaint();
}
